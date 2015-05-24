package com.hackbulgaria.javacore.pairprogramming.asciiviewer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//
// Pair programming with Adriana Stefanova

public class AsciiViewer {
	static File file;
	private static BufferedImage image;
	private static int blockWidth;

	private static BufferedImage createImage(File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		return image;
	}

	private static Color[][] getPixels(BufferedImage image) {
		int imageHeight = image.getHeight();
		int imageWidth = image.getWidth();
		Color[][] pixels = new Color[imageWidth][imageHeight];
		for (int x = 0; x < imageWidth; x++) {
			for (int y = 0; y < imageHeight; y++) {
				int colorInt = image.getRGB(x, y);
				pixels[x][y] = new Color(colorInt, false);
			}
		}
		return pixels;
	}

	private static int getAverage(Color[][] pixels, int x, int y) {
		int averageR = 0;
		int averageG = 0;
		int averageB = 0;
		int average = 0;
		int numberOfPixels = 0;
		for (int i = x * blockWidth; i < (x + 1) * blockWidth; i++) {
			for (int j = y * blockWidth; j < (y + 1) * blockWidth; j++) {
				if (inBounds(i, j)) {
					numberOfPixels++;
					averageR += pixels[i][j].getRed();
					System.out.println("R: " + averageR);
					averageG += pixels[i][j].getGreen();
					System.out.println("G: " + averageG);
					averageB += pixels[i][j].getBlue();
					System.out.println("B: " + averageB);
					average = (averageR + averageG + averageB) / 3;
					System.out.println("Average: " + average);
					System.out.println();
				}
			}
		}
		// return (int) average / numberOfPixels;
		return (int) average;
	}

	private static boolean inBounds(int i, int j) {
		return i >= 0 && j >= 0 && i < image.getWidth()
				&& j < image.getHeight();
	}

	private static Color[][] getPixelsForLargerImages(BufferedImage image) {
		final int defaultSize = 25;
		int imageHeight = image.getHeight();
		int imageWidth = image.getWidth();
		blockWidth = (int) Math.ceil((float) imageWidth / defaultSize);
		Color[][] pixels = getPixels(image);
		// for (int y = 0; y < pixels[0].length; y++) {
		// for (int x = 0; x < pixels.length; x++) {
		// System.out.print(pixels[x][y].getRGB() + " ");
		// }
		// System.out.println();
		// }
		Color[][] newPixels = new Color[imageWidth / blockWidth][imageHeight
				/ blockWidth + imageHeight % blockWidth];
		for (int x = 0; x < newPixels.length; x++) {
			for (int y = 0; y < newPixels[0].length; y++) {
				int colorInt = getAverage(pixels, x, y);
				newPixels[x][y] = new Color(colorInt, false);
			}
		}
		return newPixels;
	}

	private static int getIntensity(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		// System.out.println((red + green + blue) / 3);
		return (red + green + blue) / 3;
	}

	private static char getChar(int intensity) {
		char result = ' ';
		if (intensity > 240) {
			result = ' ';
		} else if (intensity > 200) {
			result = '.';
		} else if (intensity > 160) {
			result = '*';
		} else if (intensity > 120) {
			result = '+';
		} else if (intensity > 80) {
			result = '=';
		} else if (intensity > 40) {
			result = 'X';
		} else if (intensity > 0) {
			result = '#';
		}
		return result;
	}

	private static char[][] renderImage(Color[][] pixels) {
		char[][] result = new char[pixels.length][pixels[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				int intensity = getIntensity(pixels[i][j]);
				result[i][j] = getChar(intensity);
			}
		}
		return result;
	}

	private static void printRenderedImage(char[][] rendered) {
		for (int y = 0; y < rendered[0].length; y++) {
			for (int x = 0; x < rendered.length; x++) {
				System.out.print(rendered[x][y]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		file = new File(args[0]);
		image = createImage(file);
		// Color[][] pixels = getPixels(image);
		Color[][] pixels = getPixelsForLargerImages(image);
		char[][] result = renderImage(pixels);
		printRenderedImage(result);
	}
}