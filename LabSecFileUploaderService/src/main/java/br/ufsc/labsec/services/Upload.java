package br.ufsc.labsec.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

@Path("/upload-file")
public class Upload {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
	                           @FormDataParam("file") FormDataContentDisposition fileDetail) {
		
		try {
			
			byte[] fileBytes = IOUtils.toByteArray(uploadedInputStream);

			// Java Way
			MessageDigest MD = MessageDigest.getInstance("SHA-256");
			byte[] javahash = MD.digest(fileBytes);
			
			// Guava Way
			HashCode hashCodeFile = Hashing.sha256().hashBytes(fileBytes);
			byte[] guavaHash = hashCodeFile.asBytes();
			
			// Apache Commons Way
			byte[] apacheCommonshash = DigestUtils.sha256(fileBytes);
			
			// Hash Hexadecimal
			String javaHashHex = Hex.encodeHexString(javahash);
			String guavaHashHex = Hex.encodeHexString(guavaHash);
			String commonsHashHex = Hex.encodeHexString(apacheCommonshash);

			// Encode in Base64
			byte[] encodedApacheCommons = org.apache.commons.codec.binary.Base64.encodeBase64(commonsHashHex.getBytes());
			System.out.println("encodedApacheCommons -> " + new String(encodedApacheCommons));
			
			byte[] encoded = Base64.getEncoder().encode(javaHashHex.getBytes());
			System.out.println("java base64 encoder " + new String(encoded));   

			byte[] decoded = Base64.getDecoder().decode(encoded);
			System.out.println("java base64 deencode " + new String(decoded));   
			
			
			System.out.println("JAVA hash in HEX -> " + javaHashHex);
			System.out.println("GUAVA hash in HEX -> " + guavaHashHex);
			System.out.println("Apache Commos hash in HEX -> " + commonsHashHex);
						
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(uploadedInputStream));) {
			int numLines = 0;
			String line = null;
			while ((line = reader.readLine()) != null) {
				numLines++;
				System.out.println(line);
			}
			return Response.ok(Integer.toString(numLines), "text/plain").build();
		} catch (final Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
