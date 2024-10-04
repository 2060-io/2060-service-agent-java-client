package io.twentysixty.sa.client.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.jboss.logging.Logger;

import io.twentysixty.sa.client.jms.AbstractConsumer;

import javax.crypto.spec.IvParameterSpec;


public class Aes256cbc {
    
    private final static String alg = "AES";
    private final static String cI = "AES/CBC/PKCS5Padding";
    private static final Logger logger = Logger.getLogger(Aes256cbc.class);

    
    
    public static byte[] encrypt(String key, String iv, byte[] bytes) throws Exception {
        Cipher cipher = Cipher.getInstance(cI);
        SecretKeySpec skeySpec = new SecretKeySpec(ISOUtil.hex2byte(key), alg);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(ISOUtil.hex2byte(iv));
      //  logger.info("encrypt: key: " + key + " iv: " + iv + " bytes: " + bytes);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(bytes);
        return encrypted;
    }
    
    public static byte[] encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(ISOUtil.hex2byte(key), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ISOUtil.hex2byte(iv));
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return encrypted;
    }
        
    public static byte[] decrypt(String key, String iv, byte[] encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            // SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            SecretKeySpec skeySpec = new SecretKeySpec(ISOUtil.hex2byte(key), alg);
            // IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(), 0, 16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ISOUtil.hex2byte(iv));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            return decrypted;
    }
        
}
