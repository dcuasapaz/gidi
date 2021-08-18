package ec.gob.inspi.gidi.sit.cmm;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public abstract class MapsJava {

    //request properties 
    private static int connectTimeout=300;
    private static String region="es";
    private static String language="es";
    private static Boolean sensor= Boolean.FALSE;
    private static String APIKey="";
    
    //Stock request
    private static String[][] stockRequest=new String[0][6];

    

    
    //Abstract methods
    protected abstract void onError(URL urlRequest,String status,Exception ex);
    protected abstract String getStatus(XPath xpath, Document document);
    protected abstract void storeInfoRequest(URL urlRequest,String info,String status,Exception exception);
    

    //Protected methods
    private static int numRequest=0;
    protected void storageRequest(String urlRequest,String info,String status,
            Exception exception){
        Date date = new Date();
        numRequest+=1;
        MapsJava.stockRequest=(String[][])(this.resizeArray(MapsJava.stockRequest,numRequest));
        if(MapsJava.stockRequest[numRequest-1]==null){
                MapsJava.stockRequest[numRequest-1]=new String[6];
            }
        MapsJava.stockRequest[numRequest-1][0]=String.valueOf(numRequest);
        MapsJava.stockRequest[numRequest-1][1]=date.toString();
        MapsJava.stockRequest[numRequest-1][2]=status;
        MapsJava.stockRequest[numRequest-1][3]=urlRequest;
        MapsJava.stockRequest[numRequest-1][4]=info;
        if(exception==null){
            MapsJava.stockRequest[numRequest-1][5]="No exception";
        }else{
            MapsJava.stockRequest[numRequest-1][5]=exception.toString();
        }
        
    }
    
    protected String getSelectPropertiesRequest(){
        return "&region=" + MapsJava.region + "&language=" + MapsJava.language + 
                "&sensor=" + MapsJava.sensor;
    }
     protected ArrayList<String> getNodesString(NodeList node){
         ArrayList<String> result=new ArrayList<String>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(nodeString);
             }
        return result;
    }
     
    protected ArrayList<Double> getNodesDouble(NodeList node){
         ArrayList<Double> result=new ArrayList<Double>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Double.valueOf(nodeString));
             }
        return result;
    }
    
    protected ArrayList<Integer> getNodesInteger(NodeList node){
         ArrayList<Integer> result=new ArrayList<Integer>();
             for (int j = 0, n = node.getLength(); j < n; j++) {
                String nodeString = node.item(j).getTextContent();
                result.add(Integer.valueOf(nodeString));
             }
        return result;
    }
    
    /**
    * Author: Christian d'Heureuse (www.source-code.biz, www.inventec.ch/chdh)
    * Reallocates an array with a new size, and copies the contents
    * of the old array to the new array.
    * @param oldArray  the old array, to be reallocated.
    * @param newSize   the new array size.
    * @return          A new array with the same contents.
    */
    protected Object resizeArray (Object oldArray, int newSize) {
       int oldSize = java.lang.reflect.Array.getLength(oldArray);
       Class<?> elementType = oldArray.getClass().getComponentType();
       Object newArray = java.lang.reflect.Array.newInstance(
             elementType, newSize);
       int preserveLength = Math.min(oldSize, newSize);
       if (preserveLength > 0)
          System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
       return newArray; 
    }
    
    //Public methods
    /**
     * Comprueba si la clave de desarrollador API Google Maps es v�lida.
     * @param key clave de desarrollador API Google Maps
     * @return devuelve el estado de una petici�n con clave API. En caso de ser v�lida, devuelve
     * "OK", en cualquier otro caso la clave no es correcta.
     * @see MapsJava#setKey(java.lang.String) 
     * @see MapsJava#getKey() 
     */
    public static String APIkeyCheck(String key){
        try{
            URL url=new URL("https://maps.googleapis.com/maps/api/place/search/xml?location=0,0&radius=1000" + 
                    "&sensor=false&key=" + key);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder builder = factory.newDocumentBuilder(); 
            Document document = builder.parse(url.openStream()); 
            XPathFactory xpathFactory = XPathFactory.newInstance(); 
            XPath xpath = xpathFactory.newXPath(); 

            NodeList nodeLatLng = (NodeList) xpath.evaluate("PlaceSearchResponse/status", 
                            document, XPathConstants.NODESET);
            String status = nodeLatLng.item(0).getTextContent();
            return status;
        }catch (Exception e){
            return "NO STATUS";
        }
    }
    
    //Public access to properties of the request (Getters/Setters)
    /**
     * Devuelve el tiempo de conexi�n m�ximo (milisegundos) de espera al servidor (NO FUNCIONA)
     * @return int con tiempo m�ximo de conexi�n
     * @see MapsJava#setConnectTimeout(int) 
     */
    public static int getConnectTimeout() {
        return connectTimeout;
    }
    /**
     * Establece el tiempo m�ximo de espera (milisegundos) por el servidor (NO FUNCIONA)
     * @param aConnectTimeout asigna tiempo m�ximo de conexi�n
     * @see MapsJava#getConnectTimeout() 
     */
    public static void setConnectTimeout(int aConnectTimeout) {
        connectTimeout = aConnectTimeout;
    }
    
    /**
     * Obtiene la regi�n de b�squeda de resultados (de forma predeterminada "es").
     * M�s info. sobre regiones en http://es.wikipedia.org/wiki/CcTLD
     * @return devuelve la regi�n de b�squeda actual
     * @see MapsJava#setRegion(java.lang.String) 
     */
    public static String getRegion() {
        return region;
    }
    
    /**
     * Establece la regi�n de b�squeda de resultados (de forma predeterminada "es").
     * M�s info. sobre regiones en http://es.wikipedia.org/wiki/CcTLD
     * @param aRegion asigna la regi�n de b�squeda
     * @see MapsJava#getRegion() 
     */
    public static void setRegion(String aRegion) {
        region = aRegion;
    }

    /**
     * Obtiene el idioma en el que se muestran los resultados (de forma predeterminada "es")
     * M�s info. sobre idiomas en https://spreadsheets.google.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
     * @return devuelve el idioma actual de los resultados
     * @see MapsJava#setLanguage(java.lang.String) () 
     */
    public static String getLanguage() {
        return language;
    }
    /**
     * Establece el idioma en el que se muestran los resultados (de forma predeterminada "es")
     * M�s info. sobre idiomas en https://spreadsheets.google.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
     * @param aLanguage establece el idioma de resultados
     * @see MapsJava#getLanguage() 
     */
    public static void setLanguage(String aLanguage) {
        language = aLanguage;
    }

    /**
     * Obtiene si se est� utilizando sensor GPS (GNSS) en las peticiones para obtener ubicaci�n (de forma predeterminada es false)
     * @return devuelve true en caso de utilizaci�n del sensor y false en caso contrario
     * @see MapsJava#setSensor(java.lang.Boolean) 
     */
    public static Boolean getSensor() {
        return sensor;
    }
    /**
     * Establece el uso o no uso de un sensor GPS (GNSS) en las peticiones para obtener ubicaci�n (de forma predeterminada false)
     * @param aSensor en caso de ser true, se fuerza a utilizar sensor. Si es false, no se utiliza
     * @see MapsJava#getSensor() 
     */
    public static void setSensor(Boolean aSensor) {
        sensor = aSensor;
    }
    
    /**
     * Obtiene la clave actual de desarrollador de API Google Maps (s�lo necesario para Places)
     * @return obtiene string con clave actual
     * @see MapsJava#setKey(java.lang.String) 
     * @see MapsJava#APIkeyCheck(java.lang.String) 
     */
    public static String getKey() {
        return APIKey;
    }

    /**
     * Establece clave de desarrollador API Google Maps (s�lo necesario para Places)
     * @param aKey string con clave API de desarrollador
     * @see MapsJava#getKey() 
     * @see MapsJava#APIkeyCheck(java.lang.String) 
     */
    public static void setKey(String aKey) {
        APIKey = aKey;
    }
    
    
    //Public acces to stockRequest 
    /**
     * Obtiene registro de todas las peticiones HTTP realizadas. Conforma un String[n][6] con la siguiente
     * estructura: <br/>
     * [0][0]="N�mero de petici�n";<br/>[0][1]="Fecha/hora petici�n";<br/>[0][2]="status de la petici�n";<br/>
     * [0][3]="URL de la petici�n";<br/>[0][4]="Informaci�n sobre petici�n realizada";<br/>[0][5]="Excepciones generadas";<br/>
     * Ejemplo:<br/>
     * [0][0]="1";<br/>[0][1]="Mon Oct 07 11:30:31 CEST 2013";<br/>[0][2]="OK";<br/>
     * [0][3]=""http://maps.google.com/maps/api/geocode/xml?address=Madrid&region=es&language=es&sensor=false"";<br/>[0][4]="Geocoding request";<br/>[0][5]="No exception";<br/>
     * Tipos de status:<br/>
     * OK: indica que la solicitud del API se realiz� correctamente.<br/>
     * INVALID_REQUEST: indica que la solicitud del API se form� de forma incorrecta.<br/>
     * OVER_QUERY_LIMIT: indica que el solicitante ha superado los l�mites.<br/>
     * REQUEST_DENIED: indica que el API no complet� la solicitud, posiblemente porque el solicitante no puedo incluir correctamente un par�metro sensor v�lido.<br/>
     * UNKNOWN_ERROR: indica un error desconocido.<br/>
     * NO STATUS: indica un error al realizar la petici�n<br/>
     * @return devuelve un array de dos dimensiones con las diferentes peticiones realizadas
     */
    public static String[][] getStockRequest() {
        return stockRequest;
    }

    /**
     * Obtiene registro de la �ltima petici�n HTTP realizada. Conforma un String[6] con la siguiente estructura:</br>
     * [0]="N�mero de petici�n";<br/>[1]="Fecha/hora petici�n";<br/>[2]="status de la petici�n";<br/>
     * [3]="URL de la petici�n";<br/>[4]="Informaci�n sobre petici�n realizada";<br/>[5]="Excepciones generadas";<br/>
     * Ejemplo:<br/>
     * [0]="1";<br/>[1]="Mon Oct 07 11:30:31 CEST 2013";<br/>[2]="OK";<br/>
     * [3]="http://maps.google.com/maps/api/geocode/xml?address=Madrid&region=es&language=es&sensor=false";<br/>[4]="Geocoding request";<br/>[5]="No exception";<br/>
     * Tipos de status:<br/>
     * OK: indica que la solicitud del API se realiz� correctamente.<br/>
     * INVALID_REQUEST: indica que la solicitud del API se form� de forma incorrecta.<br/>
     * OVER_QUERY_LIMIT: indica que el solicitante ha superado los l�mites.<br/>
     * REQUEST_DENIED: indica que el API no complet� la solicitud, posiblemente porque el solicitante no puedo incluir correctamente un par�metro sensor v�lido.<br/>
     * UNKNOWN_ERROR: indica un error desconocido.<br/>
     * NO STATUS: indica un error al realizar la petici�n<br/>
     * @return array de una dimensi�n con la �ltima petici�n realizada
     * @see MapsJava#getStockRequest() 
     */
    public static  String[] getLastRequestRequest() {
        String[] stockRequestTemp=new String[6];
        System.arraycopy(stockRequest[stockRequest.length-1], 0, stockRequestTemp, 0, 6);
        return stockRequestTemp;
    }
    
    /**
     * Obtiene el status de la �ltima petici�n realizada.<br/>
     * Tipos de status:<br/>
     * OK: indica que la solicitud del API se realiz� correctamente.<br/>
     * INVALID_REQUEST: indica que la solicitud del API se form� de forma incorrecta.<br/>
     * OVER_QUERY_LIMIT: indica que el solicitante ha superado los l�mites.<br/>
     * REQUEST_DENIED: indica que el API no complet� la solicitud, posiblemente porque el solicitante no puedo incluir correctamente un par�metro sensor v�lido.<br/>
     * UNKNOWN_ERROR: indica un error desconocido.<br/>
     * NO STATUS: indica un error al realizar la petici�n<br/>
     * @return devuelve string con estado de �ltima petici�n
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestStatus() {
         return stockRequest[stockRequest.length-1][2];
    }
    /**
     * Devuelve URL asociada a la �ltima petici�n realizada.
     * @return retorna string con URL de la �ltima petici�n (por ejemplo, "http://maps.google.com/maps/api/geocode/xml?address=Madrid&region=es&language=es&sensor=false"
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestURL() {
        return stockRequest[stockRequest.length-1][3];
    }
    /**
     * Devuelve informaci�n sobre el tipo de la �ltima petici�n realizada
     * @return retorna string con informaci�n de la �ltima petici�n realizada (por ejemplo, "Geocoding request")
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestInfo() {
         return stockRequest[stockRequest.length-1][4];
    }
    /**
     * Devuelve informaci�n sobre la posible excepci�n generada en la �ltima petici�n.
     * @return retorna string con informaci�n sobre error de la �ltima petici�n (por ejemplo, "No exception")
     * @see MapsJava#getStockRequest() 
     */
    public static String getLastRequestException() {
         return stockRequest[stockRequest.length-1][5];
    }

  
}