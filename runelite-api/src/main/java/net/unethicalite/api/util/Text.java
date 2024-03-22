package net.unethicalite.api.util;


import java.util.regex.Pattern;

public class Text
{
	private static final Pattern TAG_REGEXP = Pattern.compile("<[^>]*>");
	public static String removeTags(String str)
	{
		return TAG_REGEXP.matcher(str).replaceAll("");
	}

	public static String sanitize(String string)
	{
		if (string == null)
		{
			return null;
		}
		String tagsRemoved = removeTags(string);
		if (tagsRemoved == null)
		{
			return null;
		}

        return (tagsRemoved.contains("<img") ? tagsRemoved.substring(tagsRemoved.lastIndexOf('>') + 1) : tagsRemoved).replace('\u00A0', ' ');
	}
}
