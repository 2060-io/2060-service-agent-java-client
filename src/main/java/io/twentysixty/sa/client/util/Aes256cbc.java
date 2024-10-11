package io.twentysixty.sa.client.util;

import io.twentysixty.sa.client.model.message.Ciphering;
import io.twentysixty.sa.client.model.message.Parameters;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jboss.logging.Logger;

public class Aes256cbc {

  private static final String alg = "AES";
  private static final String cI = "AES/CBC/PKCS5Padding";
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

  public static Ciphering randomCipheringData() throws Exception {
    Ciphering c = new Ciphering();
    Parameters p = new Parameters();
    p.setKey(randomKey(32));
    p.setIv(randomKey(16));
    c.setAlgorithm(cI);
    c.setParameters(p);
    return c;
  }

  private static String randomKey(int size) throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance(alg);
    keyGen.init(size * 8);
    SecretKey secretKey = keyGen.generateKey();
    return ISOUtil.dumpString(secretKey.getEncoded());
  }
}
