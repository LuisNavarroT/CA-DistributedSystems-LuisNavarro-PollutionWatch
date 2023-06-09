package grpc.service1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.service1.RiverWaterControlGrpc.RiverWaterControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RiverWaterControlServer extends RiverWaterControlImplBase{
	
	public static void main(String[] args) {
		RiverWaterControlServer serv1Riverserver = new RiverWaterControlServer();
		
		//int port = 50051;
		// Registration
		//
		Properties prop = serv1Riverserver.getProperties();
		serv1Riverserver.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;
		Server server;
		//

		try {
			server = ServerBuilder.forPort(port).addService(serv1Riverserver).build().start();
			System.out.println("Server 1 working");
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//
	private Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/Serv1_RiverWaterControl.properties")) {
			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Service 1 - Pollution WatchArea: ");
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

			String service_type = prop.getProperty("service_type");// "_GRPCServ1._tcp.local.";
			String service_name = prop.getProperty("service_name");// "River water control";
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

			String service_description_properties = prop.getProperty("service_description");//description

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
	public void oxigenLevel(testRequest request, StreamObserver<testResponse> responseObserver) {
		// TODO Auto-generated method stub
		//super.oxigenLevel(request, responseObserver);
		System.out.println("----- Receiving oxigen level (mg/L) from client -----");
		String value1 = "";
		if(request.getTestReq()>=6.5 && request.getTestReq()<=8) {
			value1 = "HEALTHY";
		}else {
			value1 = "UNHEALTHY";
		}
		
		testResponse response = testResponse.newBuilder().setTestRes("--- RPC 1 --- \nThe status of the water is: "+ value1).build();
		responseObserver.onNext( response ); 
		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<deepTestRequest> manyValues(StreamObserver<deepTestResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.manyValues(responseObserver);
		System.out.println("----- Receiving river information from client -----");
		final int[] deepTestCount = {0};
		final String[] value2 = {""};
		return new StreamObserver<deepTestRequest>() {

			@Override
			public void onNext(deepTestRequest value) {
				// TODO Auto-generated method stub
				if (value.getDeepTestReqOxy()>=6.5 && value.getDeepTestReqOxy()<=8) {
					deepTestCount[0]++;
				}
				if (value.getDeepTestReqTemp()>=20 && value.getDeepTestReqTemp()<=31.67) {
					deepTestCount[0]++;
				}
				if (value.getDeepTestReqPh()>=6 && value.getDeepTestReqPh()<=8) {
					deepTestCount[0]++;
				}
				if(deepTestCount[0]<=1) {
					value2[0] = "All levels are out of bounds, water polluted";
				}
				if(deepTestCount[0]==2){
					value2[0] = "Some levels are correct, water acceptable";
				}
				if(deepTestCount[0]==3){
					value2[0] = "All levels are correct, water is healthy";
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				//Log the error
				System.err.println("Error in manyValues: " + t.getMessage());
	            // Send an error response to the client
	            responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
			    String message = "... " + value2[0];
			    deepTestResponse response = deepTestResponse.newBuilder().setDeepTestRes(message).build();
			    responseObserver.onNext(response);
			    responseObserver.onCompleted();
			}
			
		};
				
	}

	@Override
	public StreamObserver<riverDataRequest> manyReadings(StreamObserver<riverDataResponse> responseObserver) {
		// TODO Auto-generated method stub
		//return super.manyReadings(responseObserver);
		System.out.println("----- Receiving river name and it's information to be stored -----");
		final ArrayList<String> riverNames = new ArrayList<String>();
		final ArrayList<Float> riverOxy = new ArrayList<Float>();
		final ArrayList<Float> riverTemp = new ArrayList<Float>();
		final ArrayList<Float> riverPh = new ArrayList<Float>();
		return new StreamObserver<riverDataRequest>() {

			@Override
			public void onNext(riverDataRequest value) {
				// TODO Auto-generated method stub
				riverNames.add(value.getRiverDataReq());
				riverOxy.add(value.getRiverDataReqOxy());
				riverTemp.add(value.getRiverDataReqTemp());
				riverPh.add(value.getRiverDataReqPh());				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				//Log the error
				System.err.println("Error in manyReadings: " + t.getMessage());
	            // Send an error response to the client
	            responseObserver.onError(t);
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				riverDataResponse response = riverDataResponse.newBuilder().setRiverDataRes("River data saved, thanks").build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				
			}
			
		};
			
		
	}

	
}
