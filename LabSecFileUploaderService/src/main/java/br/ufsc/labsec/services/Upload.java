package br.ufsc.labsec.services;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/upload-file")
public class Upload {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		try {

			// Getting ByteArray from file Stream
			byte[] fileBytes = IOUtils.toByteArray(uploadedInputStream);

			// Compute SHA-256 hash
			byte[] filehash = DigestUtils.sha256(fileBytes);

			// Encode in Base64
			byte[] fileEncode = Base64.encodeBase64(filehash);
			
			// Get encoded string
			String encodedFileResult = StringUtils.newStringUtf8(fileEncode);

			return Response.ok(encodedFileResult, "text/plain").build();
		} catch (final Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
