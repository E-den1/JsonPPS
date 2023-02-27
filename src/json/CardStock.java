package json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CardStock {
	
	Scanner teclado = new Scanner(System.in);
	String ClientIdentifier = "UNBE01BULK";
	String Operador = "CARD_NO_NOMINATIVE";
	String ReferenceBu, RequestId, Profile, Groupid;
	int Producto, RegistrosTotales, Renovacion, fecha, fecharenov,i;
	
	
	
	public void Principal() {
		leer ();
		Perfil(Producto);
		ExpirationDate(fecha);
		RenovationExpirationDate(fecharenov);
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
		RequestId = teclado.next();
		System.out.print("\n");
		System.out.print("Ingresa el Group ID...");
		Groupid = teclado.next();
		System.out.print("\n");
		System.out.print("¿Cuantos registros se requieren en el Bulk?...");
		RegistrosTotales = teclado.nextInt();
		System.out.print("\n");
		System.out.print("¿La solicitud es para renovación? SI (1)  NO (2)");
		Renovacion = teclado.nextInt();

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
				textoJSON.append( ",\r\n         \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\",\r\n");
				textoJSON.append("         \"GroupId\": ");
				textoJSON.append("\"");
				textoJSON.append(Groupid);
				textoJSON.append("\",\r\n");
				textoJSON.append("         \"Request\": {\r\n");
				textoJSON.append("         \"Profile\": ");
				textoJSON.append("\"");
				textoJSON.append(Profile);
             	textoJSON.append("\",\r\n"
						+ "        \"Card\": {\r\n");
				
				
				if (Renovacion ==1) {
					textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
				} else {
					textoJSON.append("          \"ExpiryDate\": " + RenovationExpirationDate(fecharenov));
				}

				textoJSON.append("\r\n"
						+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
						+ "          \"FormFactor\": \"PLASTIC\",\r\n"
						+ "          \"PIN\": \"1234\",\r\n"
						+ "          \"Status\": \"ISSUED\",\r\n"
						+ "          \"DesignCode\": \"00\",\r\n"
						+ "          \"Recipient\": {\r\n"
						+ "            \"Name\": {\r\n"
						+ "              \"LastName\": \"Def\",\r\n"
						+ "              \"FirstName\": \"Def\",\r\n"
						+ "              \"Title\": \"MR.\"\r\n"
						+ "            },\r\n"
						+ "            \"Organisation\": {\r\n"
						+ "              \"Name\": \"EDENRED\",\r\n"
						+ "              \"Department\": \"TI\"\r\n"
						+ "            },\r\n"
						+ "            \"AdditionalData\": {\r\n"
						+ "              \"Field2\": \"Def\",\r\n"
						+ "              \"Field1\": \"Def\",\r\n"
						+ "              \"Field3\": \"Def\"\r\n"
						+ "            }\r\n"
						+ "          },\r\n"
						+ "          \"AdditionalData\": {\r\n"
						+ "            \"Field1\": \"1\",\r\n"
						+ "            \"Field2\": \"2\",\r\n"
						+ "            \"Field3\": \"3\",\r\n"
						+ "            \"Field5\": \"5\",\r\n"
						+ "            \"Field4\": \"6\",\r\n"
						+ "            \"Field6\": \"7\",\r\n"
						+ "            \"Field7\": \"Def\",\r\n"
						+ "            \"Field8\": \"Def\",\r\n"
						+ "            \"Field9\": \"Def\",\r\n"
						+ "            \"Field10\": \"Def\",\r\n"
						+ "            \"CardHolderMessage\": \"mensaje\"\r\n"
						+ "          }\r\n"
						+ "        },\r\n"
						+ "        \"Delivery\": {\r\n"
						+ "          \"DeliveryCode\": \"Primera cl\",\r\n"
						+ "          \"Name\": {\r\n"
						+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
						+ "            \"FirstName\": \"MAXI\",\r\n"
						+ "            \"Tittle\": \"Sr\"\r\n"
						+ "          },\r\n"
						+ "          \"StationeryCode\": \"002\",\r\n"
						+ "          \"Address\": {\r\n"
						+ "            \"Line2\": \"Casa del tío chueco\",\r\n"
						+ "            \"Line5\": \"Molino del rey\",\r\n"
						+ "            \"Line4\": \"Campo marte\",\r\n"
						+ "            \"Line1\": \"Lago Rodolfo 46\",\r\n"
						+ "            \"PostCode\": \"09876\",\r\n"
						+ "            \"Town\": \"Ciudad de México\",\r\n"
						+ "            \"CountryCode\": \"MX\",\r\n"
						+ "            \"Line3\": \"Lago Victoria 176\"\r\n"
						+ "          },\r\n"
						+ "          \"Organisation\": {\r\n"
						+ "            \"Name\": \"EDENRED\",\r\n"
						+ "            \"Department\": \"Tecnologías de la información\"\r\n"
						+ "          }\r\n"
						+ "        }\r\n"
						+ "      }\r\n"
						+ "    },");
			}
			else if (i<=99) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n         \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\",\r\n");
				textoJSON.append("         \"GroupId\": ");
				textoJSON.append("\"");
				textoJSON.append(Groupid);
				textoJSON.append("\",\r\n");
				textoJSON.append("         \"Request\": {\r\n");
				textoJSON.append("         \"Profile\": ");
				textoJSON.append("\"");
				textoJSON.append(Profile);
             	textoJSON.append("\",\r\n"
						+ "        \"Card\": {\r\n");
							
							
							if (Renovacion ==1) {
								textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
							} else {
								textoJSON.append("          \"ExpiryDate\": " + RenovationExpirationDate(fecharenov));
							}

					    textoJSON.append("\r\n"
						+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
						+ "          \"FormFactor\": \"PLASTIC\",\r\n"
						+ "          \"PIN\": \"1234\",\r\n"
						+ "          \"Status\": \"ISSUED\",\r\n"
						+ "          \"DesignCode\": \"00\",\r\n"
						+ "          \"Recipient\": {\r\n"
						+ "            \"Name\": {\r\n"
						+ "              \"LastName\": \"TECUA\",\r\n"
						+ "              \"FirstName\": \"CÉSAR\",\r\n"
						+ "              \"Title\": \"MR.\"\r\n"
						+ "            },\r\n"
						+ "            \"Organisation\": {\r\n"
						+ "              \"Name\": \"EDENRED\",\r\n"
						+ "              \"Department\": \"TI\"\r\n"
						+ "            },\r\n"
						+ "            \"AdditionalData\": {\r\n"
						+ "              \"Field2\": \"Def\",\r\n"
						+ "              \"Field1\": \"Def\",\r\n"
						+ "              \"Field3\": \"Def\"\r\n"
						+ "            }\r\n"
						+ "          },\r\n"
						+ "          \"AdditionalData\": {\r\n"
						+ "            \"Field1\": \"1\",\r\n"
						+ "            \"Field2\": \"2\",\r\n"
						+ "            \"Field3\": \"3\",\r\n"
						+ "            \"Field5\": \"5\",\r\n"
						+ "            \"Field4\": \"6\",\r\n"
						+ "            \"Field6\": \"7\",\r\n"
						+ "            \"Field7\": \"Def\",\r\n"
						+ "            \"Field8\": \"Def\",\r\n"
						+ "            \"Field9\": \"Def\",\r\n"
						+ "            \"Field10\": \"Def\",\r\n"
						+ "            \"CardHolderMessage\": \"mensaje\"\r\n"
						+ "          }\r\n"
						+ "        },\r\n"
						+ "        \"Delivery\": {\r\n"
						+ "          \"DeliveryCode\": \"Primera cl\",\r\n"
						+ "          \"Name\": {\r\n"
						+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
						+ "            \"FirstName\": \"MAXI\",\r\n"
						+ "            \"Tittle\": \"Sr\"\r\n"
						+ "          },\r\n"
						+ "          \"StationeryCode\": \"002\",\r\n"
						+ "          \"Address\": {\r\n"
						+ "            \"Line2\": \"Casa del tío chueco\",\r\n"
						+ "            \"Line5\": \"Molino del rey\",\r\n"
						+ "            \"Line4\": \"Campo marte\",\r\n"
						+ "            \"Line1\": \"Lago Rodolfo 46\",\r\n"
						+ "            \"PostCode\": \"09876\",\r\n"
						+ "            \"Town\": \"Ciudad de México\",\r\n"
						+ "            \"CountryCode\": \"MX\",\r\n"
						+ "            \"Line3\": \"Lago Victoria 176\"\r\n"
						+ "          },\r\n"
						+ "          \"Organisation\": {\r\n"
						+ "            \"Name\": \"EDENRED\",\r\n"
						+ "            \"Department\": \"Tecnologías de la información\"\r\n"
						+ "          }\r\n"
						+ "        }\r\n"
						+ "      }\r\n"
						+ "    },");
			}
			else if (i<=999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n         \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\",\r\n");
				textoJSON.append("         \"GroupId\": ");
				textoJSON.append("\"");
				textoJSON.append(Groupid);
				textoJSON.append("\",\r\n");
				textoJSON.append("         \"Request\": {\r\n");
				textoJSON.append("         \"Profile\": ");
				textoJSON.append("\"");
				textoJSON.append(Profile);
             	textoJSON.append("\",\r\n"
						+ "        \"Card\": {\r\n");
							
							
							if (Renovacion ==1) {
								textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
							} else {
								textoJSON.append("          \"ExpiryDate\": " + RenovationExpirationDate(fecharenov));
							}

						textoJSON.append("\r\n"
						+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
						+ "          \"FormFactor\": \"PLASTIC\",\r\n"
						+ "          \"PIN\": \"1234\",\r\n"
						+ "          \"Status\": \"ISSUED\",\r\n"
						+ "          \"DesignCode\": \"00\",\r\n"
						+ "          \"Recipient\": {\r\n"
						+ "            \"Name\": {\r\n"
						+ "              \"LastName\": \"TECUA\",\r\n"
						+ "              \"FirstName\": \"CÉSAR\",\r\n"
						+ "              \"Title\": \"MR.\"\r\n"
						+ "            },\r\n"
						+ "            \"Organisation\": {\r\n"
						+ "              \"Name\": \"EDENRED\",\r\n"
						+ "              \"Department\": \"TI\"\r\n"
						+ "            },\r\n"
						+ "            \"AdditionalData\": {\r\n"
						+ "              \"Field2\": \"Def\",\r\n"
						+ "              \"Field1\": \"Def\",\r\n"
						+ "              \"Field3\": \"Def\"\r\n"
						+ "            }\r\n"
						+ "          },\r\n"
						+ "          \"AdditionalData\": {\r\n"
						+ "            \"Field1\": \"1\",\r\n"
						+ "            \"Field2\": \"2\",\r\n"
						+ "            \"Field3\": \"3\",\r\n"
						+ "            \"Field5\": \"5\",\r\n"
						+ "            \"Field4\": \"6\",\r\n"
						+ "            \"Field6\": \"7\",\r\n"
						+ "            \"Field7\": \"Def\",\r\n"
						+ "            \"Field8\": \"Def\",\r\n"
						+ "            \"Field9\": \"Def\",\r\n"
						+ "            \"Field10\": \"Def\",\r\n"
						+ "            \"CardHolderMessage\": \"mensaje\"\r\n"
						+ "          }\r\n"
						+ "        },\r\n"
						+ "        \"Delivery\": {\r\n"
						+ "          \"DeliveryCode\": \"Primera cl\",\r\n"
						+ "          \"Name\": {\r\n"
						+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
						+ "            \"FirstName\": \"MAXI\",\r\n"
						+ "            \"Tittle\": \"Sr\"\r\n"
						+ "          },\r\n"
						+ "          \"StationeryCode\": \"002\",\r\n"
						+ "          \"Address\": {\r\n"
						+ "            \"Line2\": \"Casa del tío chueco\",\r\n"
						+ "            \"Line5\": \"Molino del rey\",\r\n"
						+ "            \"Line4\": \"Campo marte\",\r\n"
						+ "            \"Line1\": \"Lago Rodolfo 46\",\r\n"
						+ "            \"PostCode\": \"09876\",\r\n"
						+ "            \"Town\": \"Ciudad de México\",\r\n"
						+ "            \"CountryCode\": \"MX\",\r\n"
						+ "            \"Line3\": \"Lago Victoria 176\"\r\n"
						+ "          },\r\n"
						+ "          \"Organisation\": {\r\n"
						+ "            \"Name\": \"EDENRED\",\r\n"
						+ "            \"Department\": \"Tecnologías de la información\"\r\n"
						+ "          }\r\n"
						+ "        }\r\n"
						+ "      }\r\n"
						+ "    },");
			}
			else if (i<=9999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n         \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\",\r\n");
				textoJSON.append("         \"GroupId\": ");
				textoJSON.append("\"");
				textoJSON.append(Groupid);
				textoJSON.append("\",\r\n");
				textoJSON.append("         \"Request\": {\r\n");
				textoJSON.append("         \"Profile\": ");
				textoJSON.append("\"");
				textoJSON.append(Profile);
             	textoJSON.append("\",\r\n"
						+ "        \"Card\": {\r\n");
							
							
							if (Renovacion ==1) {
								textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
							} else {
								textoJSON.append("          \"ExpiryDate\": " + RenovationExpirationDate(fecharenov));
							}

						textoJSON.append("\r\n"
						+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
						+ "          \"FormFactor\": \"PLASTIC\",\r\n"
						+ "          \"PIN\": \"1234\",\r\n"
						+ "          \"Status\": \"ISSUED\",\r\n"
						+ "          \"DesignCode\": \"00\",\r\n"
						+ "          \"Recipient\": {\r\n"
						+ "            \"Name\": {\r\n"
						+ "              \"LastName\": \"TECUA\",\r\n"
						+ "              \"FirstName\": \"CÉSAR\",\r\n"
						+ "              \"Title\": \"MR.\"\r\n"
						+ "            },\r\n"
						+ "            \"Organisation\": {\r\n"
						+ "              \"Name\": \"EDENRED\",\r\n"
						+ "              \"Department\": \"TI\"\r\n"
						+ "            },\r\n"
						+ "            \"AdditionalData\": {\r\n"
						+ "              \"Field2\": \"Def\",\r\n"
						+ "              \"Field1\": \"Def\",\r\n"
						+ "              \"Field3\": \"Def\"\r\n"
						+ "            }\r\n"
						+ "          },\r\n"
						+ "          \"AdditionalData\": {\r\n"
						+ "            \"Field1\": \"1\",\r\n"
						+ "            \"Field2\": \"2\",\r\n"
						+ "            \"Field3\": \"3\",\r\n"
						+ "            \"Field5\": \"5\",\r\n"
						+ "            \"Field4\": \"6\",\r\n"
						+ "            \"Field6\": \"7\",\r\n"
						+ "            \"Field7\": \"Def\",\r\n"
						+ "            \"Field8\": \"Def\",\r\n"
						+ "            \"Field9\": \"Def\",\r\n"
						+ "            \"Field10\": \"Def\",\r\n"
						+ "            \"CardHolderMessage\": \"mensaje\"\r\n"
						+ "          }\r\n"
						+ "        },\r\n"
						+ "        \"Delivery\": {\r\n"
						+ "          \"DeliveryCode\": \"Primera cl\",\r\n"
						+ "          \"Name\": {\r\n"
						+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
						+ "            \"FirstName\": \"MAXI\",\r\n"
						+ "            \"Tittle\": \"Sr\"\r\n"
						+ "          },\r\n"
						+ "          \"StationeryCode\": \"002\",\r\n"
						+ "          \"Address\": {\r\n"
						+ "            \"Line2\": \"Casa del tío chueco\",\r\n"
						+ "            \"Line5\": \"Molino del rey\",\r\n"
						+ "            \"Line4\": \"Campo marte\",\r\n"
						+ "            \"Line1\": \"Lago Rodolfo 46\",\r\n"
						+ "            \"PostCode\": \"09876\",\r\n"
						+ "            \"Town\": \"Ciudad de México\",\r\n"
						+ "            \"CountryCode\": \"MX\",\r\n"
						+ "            \"Line3\": \"Lago Victoria 176\"\r\n"
						+ "          },\r\n"
						+ "          \"Organisation\": {\r\n"
						+ "            \"Name\": \"EDENRED\",\r\n"
						+ "            \"Department\": \"Tecnologías de la información\"\r\n"
						+ "          }\r\n"
						+ "        }\r\n"
						+ "      }\r\n"
						+ "    },");			
			}
			else if (i<=99999) {
				textoJSON.append("{\r\n"
						+ "      \"id\": \"");
				textoJSON.append("00" + i + "\"");
				textoJSON.append( ",\r\n         \"RequestId\": \"");
				textoJSON.append(RequestId);
				textoJSON.append(i+"\",\r\n");
				textoJSON.append("         \"GroupId\": ");
				textoJSON.append("\"");
				textoJSON.append(Groupid);
				textoJSON.append("\",\r\n");
				textoJSON.append("         \"Request\": {\r\n");
				textoJSON.append("         \"Profile\": ");
				textoJSON.append("\"");
				textoJSON.append(Profile);
             	textoJSON.append("\",\r\n"
						+ "        \"Card\": {\r\n");
							
							
							if (Renovacion ==1) {
								textoJSON.append("          \"ExpiryDate\": " + ExpirationDate (fecha));
							} else {
								textoJSON.append("          \"ExpiryDate\": " + RenovationExpirationDate(fecharenov));
							}

						textoJSON.append("\r\n"
						+ "          \"ValidFromDate\": \"2021-03-24T22:59:36.747\",\r\n"
						+ "          \"FormFactor\": \"PLASTIC\",\r\n"
						+ "          \"PIN\": \"1234\",\r\n"
						+ "          \"Status\": \"ISSUED\",\r\n"
						+ "          \"DesignCode\": \"00\",\r\n"
						+ "          \"Recipient\": {\r\n"
						+ "            \"Name\": {\r\n"
						+ "              \"LastName\": \"TECUA\",\r\n"
						+ "              \"FirstName\": \"CÉSAR\",\r\n"
						+ "              \"Title\": \"MR.\"\r\n"
						+ "            },\r\n"
						+ "            \"Organisation\": {\r\n"
						+ "              \"Name\": \"EDENRED\",\r\n"
						+ "              \"Department\": \"TI\"\r\n"
						+ "            },\r\n"
						+ "            \"AdditionalData\": {\r\n"
						+ "              \"Field2\": \"Def\",\r\n"
						+ "              \"Field1\": \"Def\",\r\n"
						+ "              \"Field3\": \"Def\"\r\n"
						+ "            }\r\n"
						+ "          },\r\n"
						+ "          \"AdditionalData\": {\r\n"
						+ "            \"Field1\": \"1\",\r\n"
						+ "            \"Field2\": \"2\",\r\n"
						+ "            \"Field3\": \"3\",\r\n"
						+ "            \"Field5\": \"5\",\r\n"
						+ "            \"Field4\": \"6\",\r\n"
						+ "            \"Field6\": \"7\",\r\n"
						+ "            \"Field7\": \"Def\",\r\n"
						+ "            \"Field8\": \"Def\",\r\n"
						+ "            \"Field9\": \"Def\",\r\n"
						+ "            \"Field10\": \"Def\",\r\n"
						+ "            \"CardHolderMessage\": \"mensaje\"\r\n"
						+ "          }\r\n"
						+ "        },\r\n"
						+ "        \"Delivery\": {\r\n"
						+ "          \"DeliveryCode\": \"Primera cl\",\r\n"
						+ "          \"Name\": {\r\n"
						+ "            \"LastName\": \"RODRIGUEZ\",\r\n"
						+ "            \"FirstName\": \"MAXI\",\r\n"
						+ "            \"Tittle\": \"Sr\"\r\n"
						+ "          },\r\n"
						+ "          \"StationeryCode\": \"002\",\r\n"
						+ "          \"Address\": {\r\n"
						+ "            \"Line2\": \"Casa del tío chueco\",\r\n"
						+ "            \"Line5\": \"Molino del rey\",\r\n"
						+ "            \"Line4\": \"Campo marte\",\r\n"
						+ "            \"Line1\": \"Lago Rodolfo 46\",\r\n"
						+ "            \"PostCode\": \"09876\",\r\n"
						+ "            \"Town\": \"Ciudad de México\",\r\n"
						+ "            \"CountryCode\": \"MX\",\r\n"
						+ "            \"Line3\": \"Lago Victoria 176\"\r\n"
						+ "          },\r\n"
						+ "          \"Organisation\": {\r\n"
						+ "            \"Name\": \"EDENRED\",\r\n"
						+ "            \"Department\": \"Tecnologías de la información\"\r\n"
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
											Profile="cp_ermx_desp_plstc18";	
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
			
			   public String ExpirationDate (int fecha) {
					LocalDateTime today = LocalDateTime.now ();
					String expiration; 
					expiration = "";
			
						LocalDateTime fechaex  = today.plusDays(16);
						expiration = ("\""+fechaex+"\",");
						
					return expiration ;

			   }
	
			   public String RenovationExpirationDate (int fecharenov) {
					LocalDateTime today = LocalDateTime.now ();
					String expiration_renov; 
					expiration_renov = "";
			
						LocalDateTime fechaexp  = today.plusDays(365);
						expiration_renov = ("\""+fechaexp+"\",");
						
					return expiration_renov ;

			   }
			   
				
		 public String CuerpoF() {
				final StringBuilder textoJSON = new StringBuilder();
			    textoJSON.append("]" );
			    textoJSON.append("}");
				return textoJSON.toString();
			}
		    
		    public void GuardarArchivo () {
		 
		    	try {
		             String ruta = "\\C:\\Users\\amarroquin\\OneDrive - EDENRED\\Documents\\Edenred\\PRUEBAS\\PPS\\rutas\\CardStock.txt";
		            
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
				CardStock ObjPrincipal;
				ObjPrincipal = new CardStock();
				ObjPrincipal.Principal();
			}
}

