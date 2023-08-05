package io.twentysixty.sa.client.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QRCodeUtil {

    public static byte[] getQRCode(String text, int width, int height)
            throws WriterException, IOException {
        String imageFormat = "png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.
                encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream =
                new ByteArrayOutputStream();
        MatrixToImageWriter.
                writeToStream(bitMatrix, imageFormat, pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}