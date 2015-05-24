package com.hackbulgaria.corejava.webcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {

	private  URL src;
	private  Set<String> visited = new HashSet<>();
	private  Queue<String> links;

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	
	public String crawl(URL source, String needle) throws IOException {
		src = source;
		links = new LinkedList<>();
		links.add(source.toString());

		while (!links.isEmpty()) {
			String link = links.poll();
			Document document = getURLContent(link);
			if (document != null && !visited.contains(link)) {
//				System.out.println(link);
				if (containsNeedle(document, needle)) {
					return link;
				} else {
					visited.add(link);
					links.addAll(getAllLinks(document));
				}
			}

		}
		return null;
	}

	private Set<String> getAllLinks(Document doc) {
		Set<String> allLinks = new HashSet<>();
		
		Elements links = doc.select("a[href]");
		for (Element link : links) {
		
			String absHref = link.attr("abs:href").replaceAll("\\.\\.", "").replaceAll("/{3,}", "/");
			if (isInternalDomain(src, absHref)) {
				allLinks.add(absHref);
			}
		}
		return allLinks;
	}

	private boolean containsNeedle(Document doc, String needle) {
		String content = doc.body().text();
		return content.toLowerCase().contains(needle.toLowerCase());
	}

	private static Document getURLContent(String source) {

		try {
			Connection connection = Jsoup.connect(source).userAgent(USER_AGENT);
			Document document = connection.get();
			if (connection.response().statusCode() == 200) {
				return document;
			}

		} catch (IOException e) {
//			e.printStackTrace();
		}
		return null;
	}

	private boolean isInternalDomain(URL source, String lnk) {
		// System.out.println(link.toString());
		URL link = null;
		try {
			link = new URL(lnk);
		} catch (MalformedURLException e) {
			return false;
		}
		return source.getHost().equals(link.getHost());
	}

	public static void main(String[] args) throws Exception {
		URL url = new URL(args[0]);
		String needle = args[1];
		WebCrawler crawler = new WebCrawler();
		System.out.println("Searching...");
		System.out.printf("Result: %s%n",
				crawler.crawl(url, needle), needle);
	}
}
