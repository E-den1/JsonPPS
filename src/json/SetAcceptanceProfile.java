package json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class SetAcceptanceProfile {

	Scanner teclado = new Scanner(System.in);
	String ClientIdentifier = "UNBE01BULK";
	String Operador = "SET_ACCEPTANCE_PROFILE_ACCOUNT";
	String ReferenceBu, RequestId, Id, ExternalId;
	int Producto, RegistrosTotales, i;	


	public void Principal() {
		leer();
		GuardarArchivo();
		CuerpoF();
		
	}
		
	 public String LeerTxt (int index) { 
		String s1;
		s1 = "";
		try {
			try (BufferedReader bf = new BufferedReader(new FileReader ("\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\account_acceptprofile.txt"))) {
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
		System.out.print("¿Cuantos registros se requieren en el Bulk?...");
		RegistrosTotales = teclado.nextInt();
		System.out.print("\n");
		System.out.print("Ingresa LoopId:...");
		Id = teclado.next();
		System.out.print("\n");
		System.out.print("Ingresa ExternalId:...");
		ExternalId = teclado.next();
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
				textoJSON.append("      \"Id\": ");
				textoJSON.append("\"");
				textoJSON.append(Id);
				textoJSON.append("\", \r\n");
				textoJSON.append("      \"ExternalId\": ");
				textoJSON.append("\"");
				textoJSON.append(ExternalId);
				textoJSON.append("\",\r\n");
				textoJSON.append("      \"AccountNo\":" + LeerTxt(i));
				textoJSON.append("\r\n }\r\n" 
						+ "      },\r\n");
			
			}
				else if (i<=99) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\", \r\n");
					textoJSON.append("      \"Request\": { \r\n");
					textoJSON.append("      \"Id\": ");
					textoJSON.append("\"");
					textoJSON.append(Id);
					textoJSON.append("\", \r\n");
					textoJSON.append("      \"ExternalId\": ");
					textoJSON.append("\"");
					textoJSON.append(ExternalId);
					textoJSON.append("\",\r\n");
					textoJSON.append("      \"AccountNo\":" + LeerTxt(i));
					textoJSON.append("\r\n }\r\n" 
							+ "      },\r\n");
				}
				else if (i<=999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\", \r\n");
					textoJSON.append("      \"Request\": { \r\n");
					textoJSON.append("      \"Id\": ");
					textoJSON.append("\"");
					textoJSON.append(Id);
					textoJSON.append("\", \r\n");
					textoJSON.append("      \"ExternalId\": ");
					textoJSON.append("\"");
					textoJSON.append(ExternalId);
					textoJSON.append("\",\r\n");
					textoJSON.append("      \"AccountNo\":" + LeerTxt(i));
					textoJSON.append("\r\n }\r\n" 
							+ "      },\r\n");
				}
				else if (i<=9999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\", \r\n");
					textoJSON.append("      \"Request\": { \r\n");
					textoJSON.append("      \"Id\": ");
					textoJSON.append("\"");
					textoJSON.append(Id);
					textoJSON.append("\", \r\n");
					textoJSON.append("      \"ExternalId\": ");
					textoJSON.append("\"");
					textoJSON.append(ExternalId);
					textoJSON.append("\",\r\n");
					textoJSON.append("      \"AccountNo\":" + LeerTxt(i));
					textoJSON.append("\r\n }\r\n" 
							+ "      },\r\n");
				}
				else if (i<=99999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\", \r\n");
					textoJSON.append("      \"Request\": { \r\n");
					textoJSON.append("      \"Id\": ");
					textoJSON.append("\"");
					textoJSON.append(Id);
					textoJSON.append("\", \r\n");
					textoJSON.append("      \"ExternalId\": ");
					textoJSON.append("\"");
					textoJSON.append(ExternalId);
					textoJSON.append("\",\r\n");
					textoJSON.append("      \"AccountNo\":" + LeerTxt(i));
					textoJSON.append("\r\n }\r\n" 
							+ "      },\r\n");
				}
   	} return textoJSON.toString();
   	   
 }
			
   public String CuerpoF() {
		final StringBuilder textoJSON = new StringBuilder();
	    textoJSON.append("]" );
	    textoJSON.append("}");
		return textoJSON.toString();
	}
    
    public void GuardarArchivo () {
 
    	try {
             String ruta = "\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\SetAcceptanceProfile.txt";
            
             File file = new File(ruta);
             if (file.createNewFile()) {
            	 FileWriter fw = new FileWriter(file);
                 BufferedWriter bw = new BufferedWriter(fw);
    			 bw.write(Elementos ());
    			 bw.write(CuerpoF ());
                 bw.close();
            	 System.out.println("Archivo creado satisfactoriamente..");
             }else {
            	 System.out.println("El archivo no seha creado porque en la ruta de descarga ya existe un archivo con el mismo nombre.");
             }
            
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    }		
	
	public static void main(String[] args) {
		SetAcceptanceProfile ObjPrincipal;
		ObjPrincipal = new SetAcceptanceProfile();
		ObjPrincipal.Principal();
	}
	
}