package util;

public class StringUtil {
  public static String replace(String src, String from, String to) {
    if (src == null)
      return null;
    String f = "\\Q" + from + "\\E";
    return src.replaceAll(f, to);
  }

  public static String replace(String src, String[] fromSeq, String[] toSeq) {
    if (fromSeq.length != toSeq.length)
      return src;
    String ret = src;
    for (int i = 0; i < fromSeq.length; i++)
      ret = replace(ret, fromSeq[i], toSeq[i]);
    return ret;
  }
}
