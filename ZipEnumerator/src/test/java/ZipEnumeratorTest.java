import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by aurorabanuelos on 6/21/17.
 */
public class ZipEnumeratorTest {

    @Test
    public void listPathsOfZipFilesTest(){

        //Given
        ZipEnumerator zip = new ZipEnumerator("");
        int expected = 0;

        //When
        List<Path> actual = zip.listPathsOfZipFiles();

        //Then
        Assert.assertEquals(expected, actual.size());

    }

    @Test
    public void listNamesOfZipFilesTest(){
        //Given
        ZipEnumerator zip = new ZipEnumerator("");
        int expected = 0;

        //When
        zip.listPathsOfZipFiles();
        List<String> actual = zip.listNamesOfZipFiles();

        //Then
        Assert.assertEquals(expected, actual.size());
    }
}
