package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DepositTLL {
	Scanner teclado = new Scanner(System.in);
	String ClientIdentifier = "UNBE01BULK";
	String Operador = "DEPOSIT";
	String ReferenceBu, RequestId, Status;
	int Producto, RegistrosTotales, i, Ammount, fecha;	


	public void Principal() {
		leer();
		GuardarArchivo();
		CuerpoF();
		TLLExpirationDate(fecha);
		
	}
		
	 public String LeerTxt (int index) { 
		String s1;
		s1 = "";
		try {
			try (BufferedReader bf = new BufferedReader(new FileReader ("\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\\\accountTll.txt"))) {
				String bfread;
				int counter = 1;
				while ((bfread = bf.readLine()) != null) {
					if (counter == index) {
						s1 = ("\""+bfread+"\"");
					}
					counter++;
				}
			}   
		} 
				catch (Exception e) {
			System.err.println ("No se encontro archivo");
		}
	    return s1;
	}

	public void leer() {
		
		System.out.print("Ingresar Nombre de la Reference BU...");
		ReferenceBu = teclado.next();
		System.out.print("\n");
		System.out.print("Selecciona el Producto...");
		Producto = teclado.nextInt();
		System.out.print("\n");
		System.out.print("Ingresa el nombre del Request ID...");
		RequestId = teclado.next();
		System.out.print("\n");
		System.out.print("?Cuantos registros se requieren en el Bulk?...");
		RegistrosTotales = teclado.nextInt();
		System.out.print("\n");
		System.out.print("?Cual es el monto a depositar?...");
		Ammount = teclado.nextInt();
	}
	
    public String  Elementos() {
		
		final StringBuilder textoJSON = new StringBuilder();

		textoJSON.append("{\r\n");
		textoJSON.append("  \"ReferenceBU\": ");
		textoJSON.append("\"");
		textoJSON.append(ReferenceBu);
		textoJSON.append("\", \r\n");
		textoJSON.append("  \"Product\": ");
		textoJSON.append(Producto);
		textoJSON.append(", \r\n");
		textoJSON.append("  \"ClientIdentifier\": ");
		textoJSON.append("\"");
		textoJSON.append(ClientIdentifier);
		textoJSON.append("\", \r\n");
		textoJSON.append("  \"Operation\": ");
		textoJSON.append("\"");
		textoJSON.append(Operador);
		textoJSON.append("\", \r\n");
		textoJSON.append("  \"TotalRecords\": ");
		textoJSON.append(RegistrosTotales);
		textoJSON.append(",\r\n");
		textoJSON.append("\"Body\": [");
				
		for (i=1; i<=RegistrosTotales; i++) {
			if (i<=9) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n      \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\", \r\n");
				textoJSON.append("      \"Request\": { \r\n");
				textoJSON.append( "      \"SchemeServiceId\": \""
						         + "ER_HANA_GATEWAY_AUTH" + "\", \r\n");
				textoJSON.append("      \"Payee\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"Account\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"AccountNo\":" +LeerTxt(i));
				textoJSON.append( "\r\n } \r\n" + "}, \r\n");    
				textoJSON.append("      \"Payer\": { \r\n");
				textoJSON.append("      \"Acceptor\": { \r\n");
				textoJSON.append( "      \"Name\": \""
				         + "MOVIMIENTO A CUENTA" + "\" \r\n");
				textoJSON.append( "} \r\n" + "}, \r\n");    
				textoJSON.append( "      \"Operation\": \""
				         + "AUTH_AND_CLEAR" + "\", \r\n");
				textoJSON.append("      \"TxnType\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "TOPUP" + "\" \r\n },");
				textoJSON.append( "\r\n      \"BalanceCode\": \""
				         + "MAIN" + "\", \r\n");
				textoJSON.append("      \"RequestedAmount\": { \r\n");
				textoJSON.append("      \"Amount\": ");
				textoJSON.append(Ammount);
				textoJSON.append(", \r\n      \"Currency\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "MXN" + "\", \r\n");
				textoJSON.append( "      \"Exponent\": "
				         + "2" +  "\r\n } \r\n },");
				textoJSON.append("\r\n      \"TxnReference\": { \r\n");
				textoJSON.append( "      \"SchemeTxnReference\": \""
				         + "TEST_1" + "\"");
				textoJSON.append("\r\n },\r\n");
				textoJSON.append("          \"ExpiryDate\": " + TLLExpirationDate (fecha));
				textoJSON.append ("\r\n }  \r\n" + "      },\r\n");
			}
			else if (i<=99) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n      \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\", \r\n");
				textoJSON.append("      \"Request\": { \r\n");
				textoJSON.append( "      \"SchemeServiceId\": \""
						         + "ER_HANA_GATEWAY_AUTH" + "\", \r\n");
				textoJSON.append("      \"Payee\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"Account\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"AccountNo\":" +LeerTxt(i));
				textoJSON.append( "\r\n } \r\n" + "}, \r\n");    
				textoJSON.append("      \"Payer\": { \r\n");
				textoJSON.append("      \"Acceptor\": { \r\n");
				textoJSON.append( "      \"Name\": \""
				         + "MOVIMIENTO A CUENTA" + "\" \r\n");
				textoJSON.append( "} \r\n" + "}, \r\n");    
				textoJSON.append( "      \"Operation\": \""
				         + "AUTH_AND_CLEAR" + "\", \r\n");
				textoJSON.append("      \"TxnType\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "TOPUP" + "\" \r\n },");
				textoJSON.append( "\r\n      \"BalanceCode\": \""
				         + "MAIN" + "\", \r\n");
				textoJSON.append("      \"RequestedAmount\": { \r\n");
				textoJSON.append("      \"Amount\": ");
				textoJSON.append(Ammount);
				textoJSON.append(", \r\n      \"Currency\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "MXN" + "\", \r\n");
				textoJSON.append( "      \"Exponent\": "
				         + "2" +  "\r\n } \r\n },");
				textoJSON.append("\r\n      \"TxnReference\": { \r\n");
				textoJSON.append( "      \"SchemeTxnReference\": \""
				         + "TEST_1" + "\"");
				textoJSON.append("\r\n },\r\n");
				textoJSON.append("          \"ExpiryDate\": " + TLLExpirationDate (fecha));
				textoJSON.append ("\r\n }  \r\n" + "      },\r\n");
			}
			else if (i<=999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n      \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\", \r\n");
				textoJSON.append("      \"Request\": { \r\n");
				textoJSON.append( "      \"SchemeServiceId\": \""
						         + "ER_HANA_GATEWAY_AUTH" + "\", \r\n");
				textoJSON.append("      \"Payee\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"Account\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"AccountNo\":" +LeerTxt(i));
				textoJSON.append( "\r\n } \r\n" + "}, \r\n");    
				textoJSON.append("      \"Payer\": { \r\n");
				textoJSON.append("      \"Acceptor\": { \r\n");
				textoJSON.append( "      \"Name\": \""
				         + "MOVIMIENTO A CUENTA" + "\" \r\n");
				textoJSON.append( "} \r\n" + "}, \r\n");    
				textoJSON.append( "      \"Operation\": \""
				         + "AUTH_AND_CLEAR" + "\", \r\n");
				textoJSON.append("      \"TxnType\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "TOPUP" + "\" \r\n },");
				textoJSON.append( "\r\n      \"BalanceCode\": \""
				         + "MAIN" + "\", \r\n");
				textoJSON.append("      \"RequestedAmount\": { \r\n");
				textoJSON.append("      \"Amount\": ");
				textoJSON.append(Ammount);
				textoJSON.append(", \r\n      \"Currency\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "MXN" + "\", \r\n");
				textoJSON.append( "      \"Exponent\": "
				         + "2" +  "\r\n } \r\n },");
				textoJSON.append("\r\n      \"TxnReference\": { \r\n");
				textoJSON.append( "      \"SchemeTxnReference\": \""
				         + "TEST_1" + "\"");
				textoJSON.append("\r\n },\r\n");
				textoJSON.append("          \"ExpiryDate\": " + TLLExpirationDate (fecha));
				textoJSON.append ("\r\n }  \r\n" + "      },\r\n");
			}
			else if (i<=9999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n      \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\", \r\n");
				textoJSON.append("      \"Request\": { \r\n");
				textoJSON.append( "      \"SchemeServiceId\": \""
						         + "ER_HANA_GATEWAY_AUTH" + "\", \r\n");
				textoJSON.append("      \"Payee\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"Account\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"AccountNo\":" +LeerTxt(i));
				textoJSON.append( "\r\n } \r\n" + "}, \r\n");    
				textoJSON.append("      \"Payer\": { \r\n");
				textoJSON.append("      \"Acceptor\": { \r\n");
				textoJSON.append( "      \"Name\": \""
				         + "MOVIMIENTO A CUENTA" + "\" \r\n");
				textoJSON.append( "} \r\n" + "}, \r\n");    
				textoJSON.append( "      \"Operation\": \""
				         + "AUTH_AND_CLEAR" + "\", \r\n");
				textoJSON.append("      \"TxnType\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "TOPUP" + "\" \r\n },");
				textoJSON.append( "\r\n      \"BalanceCode\": \""
				         + "MAIN" + "\", \r\n");
				textoJSON.append("      \"RequestedAmount\": { \r\n");
				textoJSON.append("      \"Amount\": ");
				textoJSON.append(Ammount);
				textoJSON.append(", \r\n      \"Currency\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "MXN" + "\", \r\n");
				textoJSON.append( "      \"Exponent\": "
				         + "2" +  "\r\n } \r\n },");
				textoJSON.append("\r\n      \"TxnReference\": { \r\n");
				textoJSON.append( "      \"SchemeTxnReference\": \""
				         + "TEST_1" + "\"");
				textoJSON.append("\r\n },\r\n");
				textoJSON.append("          \"ExpiryDate\": " + TLLExpirationDate (fecha));
				textoJSON.append ("\r\n }  \r\n" + "      },\r\n");
			}
			else if (i<=99999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n      \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\", \r\n");
				textoJSON.append("      \"Request\": { \r\n");
				textoJSON.append( "      \"SchemeServiceId\": \""
						         + "ER_HANA_GATEWAY_AUTH" + "\", \r\n");
				textoJSON.append("      \"Payee\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"Account\": {");
				textoJSON.append("\r\n");
				textoJSON.append("      \"AccountNo\":" +LeerTxt(i));
				textoJSON.append( "\r\n } \r\n" + "}, \r\n");    
				textoJSON.append("      \"Payer\": { \r\n");
				textoJSON.append("      \"Acceptor\": { \r\n");
				textoJSON.append( "      \"Name\": \""
				         + "MOVIMIENTO A CUENTA" + "\" \r\n");
				textoJSON.append( "} \r\n" + "}, \r\n");    
				textoJSON.append( "      \"Operation\": \""
				         + "AUTH_AND_CLEAR" + "\", \r\n");
				textoJSON.append("      \"TxnType\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "TOPUP" + "\" \r\n },");
				textoJSON.append( "\r\n      \"BalanceCode\": \""
				         + "MAIN" + "\", \r\n");
				textoJSON.append("      \"RequestedAmount\": { \r\n");
				textoJSON.append("      \"Amount\": ");
				textoJSON.append(Ammount);
				textoJSON.append(", \r\n      \"Currency\": { \r\n");
				textoJSON.append( "      \"Code\": \""
				         + "MXN" + "\", \r\n");
				textoJSON.append( "      \"Exponent\": "
				         + "2" +  "\r\n } \r\n },");
				textoJSON.append("\r\n      \"TxnReference\": { \r\n");
				textoJSON.append( "      \"SchemeTxnReference\": \""
				         + "TEST_1" + "\"");
				textoJSON.append("\r\n },\r\n");
				textoJSON.append("          \"ExpiryDate\": " + TLLExpirationDate (fecha));
				textoJSON.append ("\r\n }  \r\n" + "      },\r\n");
			}
		}return textoJSON.toString();
}
    
    public String CuerpoF() {
		final StringBuilder textoJSON = new StringBuilder();
	    textoJSON.append("]" );
	    textoJSON.append("}");
		return textoJSON.toString();
	}
    
    public String TLLExpirationDate (int fecha) {
		LocalDateTime today = LocalDateTime.now ();
		String expiration; 
		expiration = "";

			LocalDateTime fechaex  = today.plusDays(100);
			expiration = ("\""+fechaex+"\"");
			
		return expiration ;

   }
    
    public void GuardarArchivo () {
 
    	try {
             String ruta = "\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\DepositTLL.txt";
            
             File file = new File(ruta);
             if (file.createNewFile()) {
            	 FileWriter fw = new FileWriter(file);
                 BufferedWriter bw = new BufferedWriter(fw);
    			 bw.write(Elementos ());
    			 bw.write(CuerpoF ());
                 bw.close();
            	 System.out.println("Archivo creado satisfactoriamente..");
             }else {
            	 System.out.println("El archivo no ha sido creado, en la ruta de descarga ya existe un archivo con el mismo nombre.");
             }
            
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    }		
	
	public static void main(String[] args) {
		DepositTLL ObjPrincipal;
		ObjPrincipal = new DepositTLL();
		ObjPrincipal.Principal();
	}

}
