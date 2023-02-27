package json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MerchantStore {
	
	Scanner teclado = new Scanner(System.in);
	String ClientIdentifier = "UNBE01BULK";
	String Operador = "CREATE_MERCHANT_STORE";
	String ReferenceBu, Id,  Loop, External, Store ;
	int Producto, RegistrosTotales, i, MerchantAuth, MerchantClear;	

	public void Principal() {
		leer ();
		GuardarArchivo();
		CuerpoF();
	}
		
		public void leer() {
			System.out.print("Ingresar Nombre de la Reference BU...");
			ReferenceBu = teclado.next();
			System.out.print("\n");
			System.out.print("Selecciona el Producto...");
			Producto = teclado.nextInt();
			System.out.print("\n");
			System.out.print("Ingresa el nombre del Request ID...");
			Id = teclado.next();
			System.out.print("\n");
			System.out.print("¿Cuantos registros se requieren en el Bulk?...");
			RegistrosTotales = teclado.nextInt();
			System.out.print("\n");
			System.out.print("Ingresa el LoopId");
			Loop = teclado.next();
			System.out.print("\n");
			System.out.print("Ingresa el ExternalId");
			External = teclado.next();
			System.out.print("\n");
			System.out.print("Ingresa el StoreGroupId");
			Store = teclado.next();
			System.out.print("\n");
			System.out.print("Ingresa MerchantIdAuth");
			MerchantAuth = teclado.nextInt();
			System.out.print("\n");
			System.out.print("Ingresa el MerchantIdClear");
			MerchantClear = teclado.nextInt();


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
			textoJSON.append("  \"Body\": [");
					
			for (i=1; i<=RegistrosTotales; i++) {
				if (i<=9) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\",\r\n");
					textoJSON.append("        \"Request\": {\r\n");
					textoJSON.append( "         \"Id\": \"");
					textoJSON.append(Id);
					textoJSON.append(i+"\",");
					textoJSON.append("\r\n         \"LoopId\": ");
					textoJSON.append("\"");
					textoJSON.append(Loop);
					textoJSON.append("\"");
					textoJSON.append(",\r\n");
				    textoJSON.append("         \"ExternalId\": \"" );
					textoJSON.append(External);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Name\": \"PRUEBAPPS\",\r\n");
					textoJSON.append("         \"StoreGroupId\": \"" );
				    textoJSON.append(Store);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIds\": [{\r\n");
					textoJSON.append("         \"MerchantIdAuth\": \"" );
				    textoJSON.append(MerchantAuth);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIdClear\": \"" );
				    textoJSON.append(MerchantClear);
					textoJSON.append(i+"\"\r\n");
					textoJSON.append("} \r\n"
							+"], \r\n"
							+ "         \"Behaviour\": \"ACCEPT\",\r\n"
							+ "         \"Contact\": \"null\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n");
				}
				else if (i<=99) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\",\r\n");
					textoJSON.append("        \"Request\": {\r\n");
					textoJSON.append( "         \"Id\": \"");
					textoJSON.append(Id);
					textoJSON.append(i+"\",");
					textoJSON.append("\r\n         \"LoopId\": ");
					textoJSON.append("\"");
					textoJSON.append(Loop);
					textoJSON.append("\"");
					textoJSON.append(",\r\n");
				    textoJSON.append("         \"ExternalId\": \"" );
					textoJSON.append(External);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Name\": \"PRUEBAPPS\",\r\n");
					textoJSON.append("         \"StoreGroupId\": \"" );
				    textoJSON.append(Store);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIds\": [{\r\n");
					textoJSON.append("         \"MerchantIdAuth\": \"" );
				    textoJSON.append(MerchantAuth);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIdClear\": \"" );
				    textoJSON.append(MerchantClear);
					textoJSON.append(i+"\"\r\n");
					textoJSON.append("} \r\n"
							+"], \r\n"
							+ "         \"Behaviour\": \"ACCEPT\",\r\n"
							+ "         \"Contact\": \"null\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n");
				}
				else if (i<=999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\",\r\n");
					textoJSON.append("        \"Request\": {\r\n");
					textoJSON.append( "         \"Id\": \"");
					textoJSON.append(Id);
					textoJSON.append(i+"\",");
					textoJSON.append("\r\n         \"LoopId\": ");
					textoJSON.append("\"");
					textoJSON.append(Loop);
					textoJSON.append("\"");
					textoJSON.append(",\r\n");
				    textoJSON.append("         \"ExternalId\": \"" );
					textoJSON.append(External);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Name\": \"PRUEBAPPS\",\r\n");
					textoJSON.append("         \"StoreGroupId\": \"" );
				    textoJSON.append(Store);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIds\": [{\r\n");
					textoJSON.append("         \"MerchantIdAuth\": \"" );
				    textoJSON.append(MerchantAuth);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIdClear\": \"" );
				    textoJSON.append(MerchantClear);
					textoJSON.append(i+"\"\r\n");
					textoJSON.append("} \r\n"
							+"], \r\n"
							+ "         \"Behaviour\": \"ACCEPT\",\r\n"
							+ "         \"Contact\": \"null\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n");
				}
				else if (i<=9999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\",\r\n");
					textoJSON.append("        \"Request\": {\r\n");
					textoJSON.append( "         \"Id\": \"");
					textoJSON.append(Id);
					textoJSON.append(i+"\",");
					textoJSON.append("\r\n         \"LoopId\": ");
					textoJSON.append("\"");
					textoJSON.append(Loop);
					textoJSON.append("\"");
					textoJSON.append(",\r\n");
				    textoJSON.append("         \"ExternalId\": \"" );
					textoJSON.append(External);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Name\": \"PRUEBAPPS\",\r\n");
					textoJSON.append("         \"StoreGroupId\": \"" );
				    textoJSON.append(Store);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIds\": [{\r\n");
					textoJSON.append("         \"MerchantIdAuth\": \"" );
				    textoJSON.append(MerchantAuth);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIdClear\": \"" );
				    textoJSON.append(MerchantClear);
					textoJSON.append(i+"\"\r\n");
					textoJSON.append("} \r\n"
							+"], \r\n"
							+ "         \"Behaviour\": \"ACCEPT\",\r\n"
							+ "         \"Contact\": \"null\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n");
				}
				else if (i<=99999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\",\r\n");
					textoJSON.append("        \"Request\": {\r\n");
					textoJSON.append( "         \"Id\": \"");
					textoJSON.append(Id);
					textoJSON.append(i+"\",");
					textoJSON.append("\r\n         \"LoopId\": ");
					textoJSON.append("\"");
					textoJSON.append(Loop);
					textoJSON.append("\"");
					textoJSON.append(",\r\n");
				    textoJSON.append("         \"ExternalId\": \"" );
					textoJSON.append(External);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Name\": \"PRUEBAPPS\",\r\n");
					textoJSON.append("         \"StoreGroupId\": \"" );
				    textoJSON.append(Store);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIds\": [{\r\n");
					textoJSON.append("         \"MerchantIdAuth\": \"" );
				    textoJSON.append(MerchantAuth);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"MerchantIdClear\": \"" );
				    textoJSON.append(MerchantClear);
					textoJSON.append(i+"\"\r\n");
					textoJSON.append("} \r\n"
							+"], \r\n"
							+ "         \"Behaviour\": \"ACCEPT\",\r\n"
							+ "         \"Contact\": \"null\"\r\n"
							+ "      }\r\n"
							+ "    },\r\n");
				}				
			}return textoJSON.toString();
			}
				
		

				 public String CuerpoF() {
						final StringBuilder textoJSON = new StringBuilder();
					    textoJSON.append("]" );
					    textoJSON.append("}");
						return textoJSON.toString();
					}
				    
				    public void GuardarArchivo () {
				 
				    	try {
				             String ruta = "\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\MerchanStore.txt";
				            
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
						MerchantStore ObjPrincipal;
						ObjPrincipal = new MerchantStore();
						ObjPrincipal.Principal();
					}
					
					
					
	}

