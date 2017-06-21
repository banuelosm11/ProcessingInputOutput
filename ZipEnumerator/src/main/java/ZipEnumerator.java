import com.sun.tools.example.debug.tty.AmbiguousMethodException;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by aurorabanuelos on 6/20/17.
 */
public class ZipEnumerator {
    Path directory;
    List<Path> entries;
    List<String> names;

    public ZipEnumerator(String path) {
        this.directory = Paths.get(path);
    }


    public List<Path> listPathsOfZipFiles(){
        try {
            entries = Files.walk(directory)
                    .filter(p -> p.toString().toLowerCase().endsWith(".zip"))
                    .collect(Collectors.toList());
            return entries;
        }
        catch(IOException e){
            System.out.println(e);
        }
        return null;
    }

    public List<String> listNamesOfZipFiles() {
        names = new ArrayList<>();
        for (Path e : entries) {
            names.add(e.getFileName().toString());
        }
        return names;
    }

    public void addFilebyPath(Path pathOfZip, Path fileToAdd) throws IOException{

        for(Path e: entries){
            if(e == pathOfZip){
                FileSystem zipWithAddedFile = FileSystems.newFileSystem(pathOfZip, null);
                Files.copy(fileToAdd, zipWithAddedFile.getPath("/"));
            }
        }

    }

    public void addFilebyPath(Path pathOfZip, Path fileToAdd, Path whereToInsert) throws IOException {

        for (Path e : entries) {
            if (e == pathOfZip) {

                FileSystem zipWithAddedFile = FileSystems.newFileSystem(pathOfZip, null);
                Files.copy(fileToAdd, zipWithAddedFile.getPath("/").resolve(whereToInsert));

            }
        }
    }

    //throw ambiguousFileNameException if string name is not unique
    public void addFilebyName(String nameOfZip, Path fileToAdd) throws AmbiguousMethodException, IOException{

        for(String s: names){
            if(s == nameOfZip){
                FileSystem zipWithAddedFile = FileSystems.newFileSystem(Paths.get(nameOfZip), null);
                Files.copy(fileToAdd, zipWithAddedFile.getPath("/"));
            }
        }

    }

    public void addFilebyName(String nameOfZip, Path fileToAdd, Path whereToInsert) throws AmbiguousMethodException, IOException{

        for(String s: names){
            if(s == nameOfZip){
                FileSystem zipWithAddedFile = FileSystems.newFileSystem(Paths.get(nameOfZip), null);
                Files.copy(fileToAdd, zipWithAddedFile.getPath("/").resolve(whereToInsert));
            }
        }
    }

}


