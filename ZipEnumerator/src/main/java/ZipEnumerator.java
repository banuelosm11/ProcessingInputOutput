import com.sun.tools.example.debug.tty.AmbiguousMethodException;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by aurorabanuelos on 6/20/17.
 */
public class ZipEnumerator {
    Path directory;
    List<Path> entries;

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
        List<String> names = new ArrayList<>();
        for (Path e : entries) {
            names.add(e.getFileName().toString());
        }
        return names;
    }
    //add files to zip
    public void addFilebyPath(Path p, ?){

    }
    //throw ambiguousFileNameException if string name is not unique
    public void addFilebyName(String name) throws AmbiguousMethodException{

    }

}


