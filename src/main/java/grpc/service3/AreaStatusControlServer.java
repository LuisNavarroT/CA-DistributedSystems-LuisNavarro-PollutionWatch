package grpc.service3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.examples.bidirectionstreamstrings.StringServer;
import grpc.service3.AreaStatusControlGrpc.AreaStatusControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AreaStatusControlServer extends AreaStatusControlImplBase {
	private static final Logger logger = Logger.getLogger(StringServer.class.getName());
	public static void main(String[] args) {
		AreaStatusControlServer serv3Areaserver = new AreaStatusControlServer();
		//int port = 50053;
		
		// Registration
		//
		Properties prop = serv3Areaserver.getProperties();
		serv3Areaserver.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50053;
		Server server;
		//
		try {
			server = ServerBuilder.forPort(port).addService(serv3Areaserver).build().start();
			System.out.println("Server 3 working");
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//
	private Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/Serv3_AreaStatusControl.properties")) {
			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Service 3 - Pollution WatchArea: ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	private void registerService(Properties prop) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = prop.getProperty("service_type");// "_GRPCServ3._tcp.local.";
			String service_name = prop.getProperty("service_name");// "Area status control";
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50053;

			String service_description_properties = prop.getProperty("service_description");// "Description"

			// Registration service information
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait a bit for the service to register
			Thread.sleep(1000);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//
	@Override
	public void riverHistoric(riverDataRequest request, StreamObserver<riverDataResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.riverHistoric(request, responseObserver);
		 
		 String[] RiverShannon = {"unacceptable", "acceptable", "acceptable", "acceptable", "acceptable", "acceptable", "unacceptable", "acceptable", "acceptable", "acceptable"};
		 String[] RiverBarrow = {"acceptable", "acceptable", "unacceptable", "acceptable", "acceptable", "acceptable", "acceptable", "unacceptable", "acceptable", "unacceptable"};
		 String[] RiverLiffey = {"acceptable", "unacceptable", "unacceptable", "acceptable", "unacceptable", "acceptable", "acceptable", "acceptable", "unacceptable", "acceptable"};
		
		 System.out.println("receiving name of the river...");
		 
		 if(request.getRiverDataReq().equalsIgnoreCase("Shannon")) {
			 System.out.println("Sending the result of the last 10 days of the RiverShannon");
			 for(int i=1; i<=RiverShannon.length; i++) {
				 responseObserver.onNext(riverDataResponse.newBuilder().setRiverDataRes("Day " + i + " pollution levels are " + RiverShannon[i-1]).build());
			}
			 
		 }else if(request.getRiverDataReq().equalsIgnoreCase("Barrow")) {
			 System.out.println("Sending the result of the last 10 days of the RiverShannon");
			 for(int i=1; i<=RiverBarrow.length; i++) {
				 responseObserver.onNext(riverDataResponse.newBuilder().setRiverDataRes("Day " + i + " pollution levels are " + RiverBarrow[i-1]).build());
			}
			 
		 }else if(request.getRiverDataReq().equalsIgnoreCase("Liffey")) {
			 System.out.println("Sending the result of the last 10 days of the RiverShannon");
			 for(int i=1; i<=RiverLiffey.length; i++) {
				 responseObserver.onNext(riverDataResponse.newBuilder().setRiverDataRes("Day " + i + " pollution levels are " + RiverLiffey[i-1]).build());
			}
			 
		 }else {
			 System.out.println("Client send River " + request.getRiverDataReq() + ", this one is not on the database");
			 responseObserver.onNext(riverDataResponse.newBuilder().setRiverDataRes("River " + request.getRiverDataReq() + " is not in the database").build());
		 }
		 responseObserver.onCompleted();
	}
	@Override
	public StreamObserver<waterStatusRequest> bidiRiver(StreamObserver<waterStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.bidiRiver(responseObserver);
		return new StreamObserver<waterStatusRequest>() {

			@Override
			public void onNext(waterStatusRequest value) {
				// TODO Auto-generated method stub

					StringBuilder value2 = new StringBuilder(); 
					String RiverName;
					String message = "";
					System.out.println("receiving name of the river...");
					RiverName = value.getWaterStatusReq();
					

					if(RiverName.equalsIgnoreCase("Liffey")) {
				        message = "River Liffey quick info:\nLength: 132 km\nPollution: HIGH\nSwimming: Not advisable\nFishing: LOW, only in some areas" ;  
					}else if(RiverName.equalsIgnoreCase("Barrow")) {
						message = "River Barrow quick info:\nLength: 192 km\nPollution: LOW\nSwimming: Yes, check for areas\nFishing: HIGH, many areas" ;
					}else if(RiverName.equalsIgnoreCase("Shannon")) {
						message = "River Barrow quick info:\nLength: 360 km\nPollution: MID depending on the area\nSwimming: Yes, check for areas\nFishing: MID, some areas" ;
					}else {
						message = "No information of this river is available" ;
						System.out.println("Client input river is not in database");
					}
					
					waterStatusResponse response = waterStatusResponse.newBuilder().setWaterStatusRes(message).build();        					
				    responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				//Log the error
				System.err.println("Error in BidiRiver: " + t.getMessage());
	            // Send an error response to the client
	            responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method 
				responseObserver.onCompleted();
				
			}
		
		};
	}
	@Override
	public StreamObserver<neighborhoodStatusRequest> bidiNeighbourhood(
			StreamObserver<neighborhoodStatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.bidiNeighbourhood(responseObserver);
		return new StreamObserver<neighborhoodStatusRequest>() {

			@Override
			public void onNext(neighborhoodStatusRequest value) {
				// TODO Auto-generated method stub

					StringBuilder value2 = new StringBuilder(); 
					String NeighborhoodName;
					String message = "";
					System.out.println("receiving name of the neighborhood...");
					NeighborhoodName = value.getNeighborhoodStatusReq();
					

					if(NeighborhoodName.equalsIgnoreCase("Churchtown")) {
				        message = "Neighborhood Churchtown quick info:\nEirCode: D14\nSafety: High\nPollution: LOW\nPeople: 8,736";  
					}else if(NeighborhoodName.equalsIgnoreCase("Temple bar")) {
						message = "Neighborhood Temple bar quick info:\nEirCode: D02\nSafety: Mid, many bars\nPollution: High\nPeople: 3,000";
					}else if(NeighborhoodName.equalsIgnoreCase("Ranelagh")) {
						message = "Neighborhood Ranelagh quick info:\nEirCode: D06\nSafety: High\nPollution: very Low\nPeople: 1,268" ;
					}else {
						message = "No information of this Neighborhood is available" ;
						System.out.println("Client input Neighborhood is not in database");
					}
					
					neighborhoodStatusResponse response = neighborhoodStatusResponse.newBuilder().setNeighborhoodStatusRes(message).build();        					
				    responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				//Log the error
				System.err.println("Error in Bidineighborhood: " + t.getMessage());
	            // Send an error response to the client
	            responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method 
				responseObserver.onCompleted();
				
			}
		
		};
		
	}
	

}
