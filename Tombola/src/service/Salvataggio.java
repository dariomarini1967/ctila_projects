package service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import awt.NumeriEstratti;

public class Salvataggio {
	public Salvataggio(int[] arrayDaSalvare) {
		try {
			DataOutputStream dos=new DataOutputStream(new FileOutputStream(NumeriEstratti.file));
			int i;
			for (i = 1; i <= 90; i++) {
				Integer temp = new Integer(arrayDaSalvare[i]);
				dos.writeBytes(temp.toString());
				dos.writeByte(13);
				dos.writeByte(10);
			}
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}