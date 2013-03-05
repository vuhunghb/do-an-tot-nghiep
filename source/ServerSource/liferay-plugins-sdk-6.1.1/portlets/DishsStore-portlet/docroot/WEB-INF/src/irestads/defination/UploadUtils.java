package irestads.defination;

import org.primefaces.event.FileUploadEvent;

public class UploadUtils {

	public static String handleFileUpload(FileUploadEvent event) throws InterruptedException {
		System.out.println("Starting...");
		byte[] byteContent = event.getFile().getContents();
		return Base64.encodeBytes(byteContent);
	}

}
