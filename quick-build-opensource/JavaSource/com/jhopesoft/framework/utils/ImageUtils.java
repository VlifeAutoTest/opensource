package com.jhopesoft.framework.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static BufferedImage resize(File file, int targetW, int targetH) throws IOException {
		BufferedImage source = ImageIO.read(file);
		return resize(source, targetW, targetH);
	}

	public static BufferedImage resize(BufferedImage source, int targetW, int targetH) throws IOException {
		BufferedImage result = null;
		result = new BufferedImage(targetW, targetH, BufferedImage.TYPE_INT_RGB);
		result.getGraphics().drawImage(source.getScaledInstance(targetW, targetH, java.awt.Image.SCALE_SMOOTH), 0, 0,
				null);
		return result;
	}

}
