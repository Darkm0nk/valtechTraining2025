package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.BufferCapabilities;
import java.io.*;

import org.junit.jupiter.api.Test;

class IOTests {
	
	@Test
	
	public void testBufferedReader() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testReaders() {
		try(Reader reader = new FileReader(new File("data.txt"))){
			try(Writer writer = new FileWriter(new File("dataOut.txt"))){
				char [] buff = new char[4];
				int i = -1;
				while ((i =reader.read(buff)) != -1) {
					writer.write(buff,0,i);
				}
				writer.flush();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChainingStreams() {
		try(InputStream is = new BufferedInputStream(new FileInputStream(new File("data.txt")))) {
			try(OutputStream os = new FileOutputStream(new File("dataCopy.txt"))){
				byte [] buff = new byte[4]; //8192 16768
				int i = 0 ;
			
				while((i=is.read(buff)) != -1) {
//					is.read(buff);
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadTryWithResources() {
		try(InputStream is = new FileInputStream(new File("data.txt"))) {
			try(OutputStream os = new FileOutputStream(new File("dataCopy.txt"))){
				byte [] buff = new byte[4]; //8192 16768
				int i = 0 ;
			
				while((i=is.read(buff)) != -1) {
//					is.read(buff);
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRead() {
		InputStream is = null;
		try {
			is = new FileInputStream(new File("data.txt"));
			assertEquals('H', ((byte)is.read()));
			assertEquals('e', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
