package bin;

import java.io.*;
public class AppendFile {
public static void main(String args[]){

String name = "Ankur";
String city = "Tyagi";
String phone = "00000000000";

try { 

PrintStream out = new PrintStream(new AppendFileStream("BellTime.file"));

for(int i=0;i<5;i++){

if(i == 0){

out.print("Start Time \t");
out.print("Duration \t");
out.print("Sound Type \t");
out.println();

}else{

out.print(name+"\t");
out.print(city+"\t");
out.print(phone+"\t");
out.println();

}

}

} catch(Exception e) {

System.out.println(e.toString());

}


}

}


class AppendFileStream extends OutputStream {


RandomAccessFile fd;


public AppendFileStream(String file) throws IOException {

fd = new RandomAccessFile(file,"rw");
fd.seek(fd.length());
}

public void close() throws IOException {


fd.close();

}
public void write(byte[] b) throws IOException {
fd.write(b);
}
public void write(byte[] b,int off,int len) throws IOException {


fd.write(b,off,len);


}
public void write(int b) throws IOException {

fd.write(b);


}
}