import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class LocalSelection implements Transferable{
	private Object obj;
	public LocalSelection(Object obj){
		this.obj = obj;
	}
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		if(!isDataFlavorSupported(flavor)){
			throw new UnsupportedFlavorException(flavor);
		}
		if(flavor.equals(DataFlavor.stringFlavor)){
			return obj.toString();
		}
		return obj;
	}
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		DataFlavor[] flavors = new DataFlavor[2];
		Class c = obj.getClass();
		String mimeType = "application/x-java-jvm-local-objectref;class="+c.getName();
		try{
			flavors[0]=new DataFlavor(mimeType);
			flavors[1]=DataFlavor.stringFlavor;
			return flavors;
 		}
		catch(ClassNotFoundException e){
			return null;
		}
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return flavor.equals(DataFlavor.stringFlavor) || flavor.getPrimaryType().equals("application")
				&& flavor.getSubType().equals("x-java-jvm-local-objectref")
				&& flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
	}
	
}
