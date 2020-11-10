package team.jit.workshop;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadingTest {

    @Test
    public void bufferedReaderTest() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/myfile"));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void filesTest() throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src/test/resources/myfile"));

        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void filesNIOBufferedReader() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/test/resources/myfile"));

        System.out.println(bufferedReader.readLine());
    }

    @Test
    public void filesLines() throws IOException {
        Stream<String> lines = Files.lines(Path.of("src/test/resources/myfile"));

        lines.forEach(System.out::println);
    }

    @Test
    public void scannerTest() throws IOException {
        Scanner scanner = new Scanner(Path.of("src/test/resources/myfile"));
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    @Test
    public void dataInputStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/test/resources/myfile"));
        System.out.println(dataInputStream.available());
    }

    @Test
    public void fileChannelTest() throws IOException {
        long startTime = System.currentTimeMillis();

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/test/resources/myfile", "r");
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        fileChannel.read(buffer);

        System.out.println(new String(buffer.array()));

        long duration = System.currentTimeMillis() - startTime;

        System.out.println(duration);
    }
}
