package com.utnfra.examen1.datos;

import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Xml;

import com.utnfra.examen1.entities.Noticia;

public class ParserNoticias {

	public static String ITEM = "item";
	public static String TITLE = "title";
	public static String LINK = "link";
	public static String DESCRIPTION = "description";
	public static String AUTHOR = "author";
	public static String CATEGORY = "category";
	public static String PUBDATE = "pubDate";
    public static String THUMBNAIL = "thumbnail";
    public static String ENCLOSURE = "enclosure";


	private XmlPullParser parser;
	
	public ParserNoticias(String xmlTxt) 
	{
		parser = Xml.newPullParser();		
		try {
			parser.setInput(new StringReader(xmlTxt));
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Noticia> parseListaNoticias()
	{
		ArrayList<Noticia> noticias = null;		
		int event;
		Noticia noticia = null;
		
        try
        {
        	event = parser.getEventType(); 
            while (event != XmlPullParser.END_DOCUMENT)
            {
                String tag = null;
 
                switch (event)
                {
                    case XmlPullParser.START_DOCUMENT:
 
                        noticias = new ArrayList<Noticia>();
                        break;
 
                    case XmlPullParser.START_TAG:
 
                        tag = parser.getName();
 
                        if (tag.equals(ITEM))
                        {
                        	// inicio del tag <item>
                            noticia = new Noticia();
                        }
                        else if (noticia != null)
                        {
                        	// Tags dentro de <item></item>                        	
                            if (tag.equals(LINK))
                            {
                                noticia.setLink(parser.nextText());
                            }
                            else if (tag.equals(DESCRIPTION))
                            {
                                noticia.setDescription(parser.nextText());
                            }
                            else if (tag.equals(PUBDATE))
                            {
                                noticia.setPubDate(parser.nextText());
                            }
                            else if (tag.equals(TITLE))
                            {
                                noticia.setTitle(parser.nextText());
                            }
                            else if (tag.equals(THUMBNAIL) || tag.equals(ENCLOSURE))
                            {
                                noticia.setImageUrl(parser.getAttributeValue(null,"url"));
                            }
                        }
                        break;
 
                    case XmlPullParser.END_TAG:
 
                    	// se llago al final del tag </item>
                        tag = parser.getName();
 
                        if (tag.equals(ITEM) && noticia != null)
                        {
                        	// agrego el objeto noticia a la lista
                            noticias.add(noticia);                            
                            noticia=null;
                        }
                        break;
                }
 
                event = parser.next();
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
 
        return noticias;
    }
}
