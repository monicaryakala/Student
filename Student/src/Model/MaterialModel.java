package Model;

import java.io.InputStream;
import java.io.OutputStream;

public class MaterialModel {
private String field;
private String filename;
private InputStream inputstream;
private String contenttype;
private OutputStream outputstream;
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public InputStream getInputstream() {
	return inputstream;
}
public void setInputstream(InputStream inputstream) {
	this.inputstream = inputstream;
}
public String getContenttype() {
	return contenttype;
}
public void setContenttype(String contenttype) {
	this.contenttype = contenttype;
}
public OutputStream getOutputstream() {
	return outputstream;
}
public void setOutputstream(OutputStream outputstream) {
	this.outputstream = outputstream;
}
public MaterialModel(){
	
}
public MaterialModel(String field, String filename, InputStream inputstream, String contenttype, OutputStream outputstream) {
	this.field = field;
	this.filename = filename;
	this.inputstream = inputstream;
	this.contenttype = contenttype;
	this.outputstream = outputstream;
}
@Override
public String toString() {
	return "MaterialModel [field=" + field + ", filename=" + filename + ", inputstream=" + inputstream
			+ ", contenttype=" + contenttype + ", outputstream=" + outputstream + "]";
}

}
