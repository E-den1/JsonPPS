package json;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;


public class RenewalNominative {

		Scanner teclado = new Scanner(System.in);
		String ClientIdentifier = "UNBE01BULK";
		String Operador = "CARD_RENEWAL_NOMINATIVE_TO_NOMINATIVE";
		String ReferenceBu, RequestId, Profile, Groupid;
		int Producto, RegistrosTotales, fecha, i;

		public void Principal() {
			leer ();
			Perfil(Producto);
			ExpirationDate(fecha);
			GuardarArchivo();
			CuerpoF();
			
		}
		

		public String LeertxtAccount (int index) { 
			String s1;
			s1 = "";
			try {
				try (BufferedReader bf = new BufferedReader(new FileReader ("\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\accountrenewalnom.txt"))) {
					String bfread;
					int counter = 1;
					while ((bfread = bf.readLine()) != null) {
						if (counter == index) {
							s1 = ("\""+bfread+"\",");
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

		public String LeertxtCard (int index) { 
			String s1;
			s1 = "";
			try {
				try (BufferedReader bf = new BufferedReader(new FileReader ("\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\cardrenewalnom.txt"))) {
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
			System.out.print("Ingresa el Group ID...");
			Groupid = teclado.next();
			System.out.print("\n");
			System.out.print("¿Cuantos registros se requieren en el Bulk?...");
			RegistrosTotales = teclado.nextInt();
			
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
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n");
					textoJSON.append("      \"GroupId\": ");
					textoJSON.append("\"");
					textoJSON.append(Groupid);
				    textoJSON.append("\",\r\n");
					textoJSON.append( "      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Request\": {\r\n");
					textoJSON.append("         \"Profile\": ");
					textoJSON.append("\"");
					textoJSON.append(Profile);
					textoJSON.append("\", \r\n");
					textoJSON.append("         \"AccountNo\":" +LeertxtAccount(i));
					textoJSON.append("\r\n"
							+ "         \"Card\": {\r\n");
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
					
				    textoJSON.append("\r\n"
				    		+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
				    		+ "          \"DesignCode\": \"Def\",\r\n"
				    		+ "          \"StationeryCode\": \"Def\",\r\n "
							+ "        \"OriginalCard\": {\r\n"
				            + "          \"Reason\": \"OTHER\",\r\n"
							+ "          \"KeepPin\": \"true\",\r\n"
							+ "          \"OverrideBlock\": \"false\",\r\n");			
					textoJSON.append("          \"CardNumber\":" +LeertxtCard(i));
					textoJSON.append("\r\n            },\r\n"
							+ "          \"Recipient\": {\r\n"
							+ "            \"Name\": {\r\n"
							+ "              \"LastName\": \"Default\",\r\n"
							+ "              \"FirstName\": \"Default\"\r\n"
							+ "            },\r\n"
							+ "            \"Organisation\": {\r\n"
							+ "              \"Name\": \"EDENRED\"\r\n"
							+ "            },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\",\r\n"
							+ "              \"Field5\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "        \"Delivery\": {\r\n"
							+ "          \"StationeryCode\": \"Def\",\r\n"
							+ "          \"Name\": {\r\n"
							+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
							+ "            \"FirstName\": \"MAXI\"\r\n"
							+ "          },\r\n"
							+ "          \"Address\": {\r\n"
							+ "            \"Line2\": \"De\",\r\n"
							+ "            \"Line1\": \"De\",\r\n"
							+ "            \"PostCode\": \"De\",\r\n"
							+ "            \"Town\": \"Ciudad de México\",\r\n"
							+ "            \"CountryCode\": \"MX\"\r\n"
							+ "          },\r\n"
							+ "          \"Organisation\": {\r\n"
							+ "            \"Name\": \"EDENRED\"\r\n"
							+ "          }\r\n"
							+ "        }\r\n"
							+ "      }\r\n"
							+ "    },");
				}
				else if (i<=99) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n");
					textoJSON.append("      \"GroupId\": ");
					textoJSON.append("\"");
					textoJSON.append(Groupid);
				    textoJSON.append("\",\r\n");
					textoJSON.append( "      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Request\": {\r\n");
					textoJSON.append("         \"Profile\": ");
					textoJSON.append("\"");
					textoJSON.append(Profile);
					textoJSON.append("\", \r\n");
					textoJSON.append("         \"AccountNo\":" +LeertxtAccount(i));
					textoJSON.append("\r\n"
							+ "         \"Card\": {\r\n");
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
					
				    textoJSON.append("\r\n"
				    		+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
				    		+ "          \"DesignCode\": \"Def\",\r\n"
				    		+ "          \"StationeryCode\": \"Def\",\r\n "
							+ "        \"OriginalCard\": {\r\n"
				            + "          \"Reason\": \"OTHER\",\r\n"
							+ "          \"KeepPin\": \"true\",\r\n"
							+ "          \"OverrideBlock\": \"false\",\r\n");			
					textoJSON.append("          \"CardNumber\":" +LeertxtCard(i));
					textoJSON.append("\r\n            },\r\n"
							+ "          \"Recipient\": {\r\n"
							+ "            \"Name\": {\r\n"
							+ "              \"LastName\": \"Default\",\r\n"
							+ "              \"FirstName\": \"Default\"\r\n"
							+ "            },\r\n"
							+ "            \"Organisation\": {\r\n"
							+ "              \"Name\": \"EDENRED\"\r\n"
							+ "            },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\",\r\n"
							+ "              \"Field5\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "        \"Delivery\": {\r\n"
							+ "          \"StationeryCode\": \"Def\",\r\n"
							+ "          \"Name\": {\r\n"
							+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
							+ "            \"FirstName\": \"MAXI\"\r\n"
							+ "          },\r\n"
							+ "          \"Address\": {\r\n"
							+ "            \"Line2\": \"De\",\r\n"
							+ "            \"Line1\": \"De\",\r\n"
							+ "            \"PostCode\": \"De\",\r\n"
							+ "            \"Town\": \"Ciudad de México\",\r\n"
							+ "            \"CountryCode\": \"MX\"\r\n"
							+ "          },\r\n"
							+ "          \"Organisation\": {\r\n"
							+ "            \"Name\": \"EDENRED\"\r\n"
							+ "          }\r\n"
							+ "        }\r\n"
							+ "      }\r\n"
							+ "    },");
				}
				else if (i<=999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n");
					textoJSON.append("      \"GroupId\": ");
					textoJSON.append("\"");
					textoJSON.append(Groupid);
				    textoJSON.append("\",\r\n");
					textoJSON.append( "      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Request\": {\r\n");
					textoJSON.append("         \"Profile\": ");
					textoJSON.append("\"");
					textoJSON.append(Profile);
					textoJSON.append("\", \r\n");
					textoJSON.append("         \"AccountNo\":" +LeertxtAccount(i));
					textoJSON.append("\r\n"
							+ "         \"Card\": {\r\n");
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
					
				    textoJSON.append("\r\n"
				    		+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
				    		+ "          \"DesignCode\": \"Def\",\r\n"
				    		+ "          \"StationeryCode\": \"Def\",\r\n "
							+ "        \"OriginalCard\": {\r\n"
				            + "          \"Reason\": \"OTHER\",\r\n"
							+ "          \"KeepPin\": \"true\",\r\n"
							+ "          \"OverrideBlock\": \"false\",\r\n");			
					textoJSON.append("          \"CardNumber\":" +LeertxtCard(i));
					textoJSON.append("\r\n            },\r\n"
							+ "          \"Recipient\": {\r\n"
							+ "            \"Name\": {\r\n"
							+ "              \"LastName\": \"Default\",\r\n"
							+ "              \"FirstName\": \"Default\"\r\n"
							+ "            },\r\n"
							+ "            \"Organisation\": {\r\n"
							+ "              \"Name\": \"EDENRED\"\r\n"
							+ "            },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\",\r\n"
							+ "              \"Field5\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "        \"Delivery\": {\r\n"
							+ "          \"StationeryCode\": \"Def\",\r\n"
							+ "          \"Name\": {\r\n"
							+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
							+ "            \"FirstName\": \"MAXI\"\r\n"
							+ "          },\r\n"
							+ "          \"Address\": {\r\n"
							+ "            \"Line2\": \"De\",\r\n"
							+ "            \"Line1\": \"De\",\r\n"
							+ "            \"PostCode\": \"De\",\r\n"
							+ "            \"Town\": \"Ciudad de México\",\r\n"
							+ "            \"CountryCode\": \"MX\"\r\n"
							+ "          },\r\n"
							+ "          \"Organisation\": {\r\n"
							+ "            \"Name\": \"EDENRED\"\r\n"
							+ "          }\r\n"
							+ "        }\r\n"
							+ "      }\r\n"
							+ "    },");
				}
				else if (i<=9999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n");
					textoJSON.append("      \"GroupId\": ");
					textoJSON.append("\"");
					textoJSON.append(Groupid);
				    textoJSON.append("\",\r\n");
					textoJSON.append( "      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Request\": {\r\n");
					textoJSON.append("         \"Profile\": ");
					textoJSON.append("\"");
					textoJSON.append(Profile);
					textoJSON.append("\", \r\n");
					textoJSON.append("         \"AccountNo\":" +LeertxtAccount(i));
					textoJSON.append("\r\n"
							+ "         \"Card\": {\r\n");
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
					
				    textoJSON.append("\r\n"
				    		+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
				    		+ "          \"DesignCode\": \"Def\",\r\n"
				    		+ "          \"StationeryCode\": \"Def\",\r\n "
							+ "        \"OriginalCard\": {\r\n"
				            + "          \"Reason\": \"OTHER\",\r\n"
							+ "          \"KeepPin\": \"true\",\r\n"
							+ "          \"OverrideBlock\": \"false\",\r\n");			
					textoJSON.append("          \"CardNumber\":" +LeertxtCard(i));
					textoJSON.append("\r\n            },\r\n"
							+ "          \"Recipient\": {\r\n"
							+ "            \"Name\": {\r\n"
							+ "              \"LastName\": \"Default\",\r\n"
							+ "              \"FirstName\": \"Default\"\r\n"
							+ "            },\r\n"
							+ "            \"Organisation\": {\r\n"
							+ "              \"Name\": \"EDENRED\"\r\n"
							+ "            },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\",\r\n"
							+ "              \"Field5\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "        \"Delivery\": {\r\n"
							+ "          \"StationeryCode\": \"Def\",\r\n"
							+ "          \"Name\": {\r\n"
							+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
							+ "            \"FirstName\": \"MAXI\"\r\n"
							+ "          },\r\n"
							+ "          \"Address\": {\r\n"
							+ "            \"Line2\": \"De\",\r\n"
							+ "            \"Line1\": \"De\",\r\n"
							+ "            \"PostCode\": \"De\",\r\n"
							+ "            \"Town\": \"Ciudad de México\",\r\n"
							+ "            \"CountryCode\": \"MX\"\r\n"
							+ "          },\r\n"
							+ "          \"Organisation\": {\r\n"
							+ "            \"Name\": \"EDENRED\"\r\n"
							+ "          }\r\n"
							+ "        }\r\n"
							+ "      }\r\n"
							+ "    },");
				}
				else if (i<=99999) {
					textoJSON.append("{\r\n"
							+ "      \"id\": \"");
					textoJSON.append("00" + i + "\"");
					textoJSON.append( ",\r\n");
					textoJSON.append("      \"GroupId\": ");
					textoJSON.append("\"");
					textoJSON.append(Groupid);
				    textoJSON.append("\",\r\n");
					textoJSON.append( "      \"RequestId\": \"");
					textoJSON.append(RequestId);
					textoJSON.append(i+"\",\r\n");
					textoJSON.append("         \"Request\": {\r\n");
					textoJSON.append("         \"Profile\": ");
					textoJSON.append("\"");
					textoJSON.append(Profile);
					textoJSON.append("\", \r\n");
					textoJSON.append("         \"AccountNo\":" +LeertxtAccount(i));
					textoJSON.append("\r\n"
							+ "         \"Card\": {\r\n");
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
					
				    textoJSON.append("\r\n"
				    		+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
				    		+ "          \"DesignCode\": \"Def\",\r\n"
				    		+ "          \"StationeryCode\": \"Def\",\r\n "
							+ "        \"OriginalCard\": {\r\n"
				            + "          \"Reason\": \"OTHER\",\r\n"
							+ "          \"KeepPin\": \"true\",\r\n"
							+ "          \"OverrideBlock\": \"false\",\r\n");			
					textoJSON.append("          \"CardNumber\":" +LeertxtCard(i));
					textoJSON.append("\r\n            },\r\n"
							+ "          \"Recipient\": {\r\n"
							+ "            \"Name\": {\r\n"
							+ "              \"LastName\": \"Default\",\r\n"
							+ "              \"FirstName\": \"Default\"\r\n"
							+ "            },\r\n"
							+ "            \"Organisation\": {\r\n"
							+ "              \"Name\": \"EDENRED\"\r\n"
							+ "            },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "            \"AdditionalData\": {\r\n"
							+ "              \"Field1\": \"Def\",\r\n"
							+ "              \"Field2\": \"Def\",\r\n"
							+ "              \"Field3\": \"Def\",\r\n"
							+ "              \"Field5\": \"Def\"\r\n"
							+ "            }\r\n"
							+ "          },\r\n"
							+ "        \"Delivery\": {\r\n"
							+ "          \"StationeryCode\": \"Def\",\r\n"
							+ "          \"Name\": {\r\n"
							+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
							+ "            \"FirstName\": \"MAXI\"\r\n"
							+ "          },\r\n"
							+ "          \"Address\": {\r\n"
							+ "            \"Line2\": \"De\",\r\n"
							+ "            \"Line1\": \"De\",\r\n"
							+ "            \"PostCode\": \"De\",\r\n"
							+ "            \"Town\": \"Ciudad de México\",\r\n"
							+ "            \"CountryCode\": \"MX\"\r\n"
							+ "          },\r\n"
							+ "          \"Organisation\": {\r\n"
							+ "            \"Name\": \"EDENRED\"\r\n"
							+ "          }\r\n"
							+ "        }\r\n"
							+ "      }\r\n"
							+ "    },");
				}
			   }return textoJSON.toString();
			}
				   public void Perfil(int a) {
						if (Producto == 71 ) {
							Profile="cardprofile1";
						}
						else
							if(Producto ==81) {
								Profile="cardprofile2";	
							}
							else
								if(Producto ==47) {
									Profile="cp_ermx_rest_plstc14";	
								}
								else
									if(Producto ==57) {
										Profile="cp_ermx_desp_plstc17";	
									}
									else
										if(Producto ==19) {
											Profile="cp_ermx_desp_plstc13";	
										}
										else
											if(Producto ==32) {
												Profile="cp_ermx_desp_plstc01";	
											}
											else
												if(Producto ==48) {
													Profile="cp_ermx_regl_plstc06";	
												}
												else
													if(Producto ==68) {
														Profile="cp_ermx_regl_plstc15";	
													}
													else
														if(Producto ==34) {
															Profile="cp_ermx_vest_plstc05";
														}
															else
																if(Producto ==54) {
																	Profile="cp_ermx_vest_plstc16";
																}
																else {
																	System.out.print("No existe la opción");
																}
					}
				
			 public String CuerpoF() {
					final StringBuilder textoJSON = new StringBuilder();
				    textoJSON.append("]" );
				    textoJSON.append("}");
					return textoJSON.toString();
				}
			    
			  public String ExpirationDate (int fecha) {
					LocalDateTime today = LocalDateTime.now ();
					String expiration; 
					expiration = "";
			
						LocalDateTime fechaex  = today.plusDays(365);
						expiration = ("\""+fechaex+"\",");
						
					return expiration ;

			   }
			 
			    public void GuardarArchivo () {
			 
			    	try {
			             String ruta = "\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\RenewalNominative.txt";
			            
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
					RenewalNominative ObjPrincipal;
					ObjPrincipal = new RenewalNominative();
					ObjPrincipal.Principal();
				}
				
	}

