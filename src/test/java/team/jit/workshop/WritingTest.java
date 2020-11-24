package team.jit.workshop;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WritingTest {

    private static final int LOOP_SIZE = 100000;
    private static final int LINE_SIZE = 200;

    @Test
    public void runBenchmarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(6)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Test
    public void bufferedWriter() throws Exception {
//        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("bufferedReader"+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bufferedReader"+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)), 201);

        for (int i = 0; i < LOOP_SIZE; i++) {
            bufferedWriter.write(RandomStringUtils.randomAlphanumeric(LINE_SIZE)+"\n");
        }

        bufferedWriter.close();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Test
    public void dataOutputStream() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("dataOutputStream_"+LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));

        for (int i = 0; i < LOOP_SIZE; i++) {
            dataOutputStream.writeUTF(RandomStringUtils.randomAlphanumeric(LINE_SIZE)+"\n");
        }

        dataOutputStream.close();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Test
    public void files() throws Exception {
        String fileName = "filesWriteString_" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        for (int i = 0; i < LOOP_SIZE; i++) {
            Files.writeString(Paths.get(fileName), RandomStringUtils.randomAlphanumeric(LINE_SIZE)+"\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Test
    public void fileChannel() throws Exception {
        String fileName = "fileChannel" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(LINE_SIZE+1);

        for (int i = 0; i < LOOP_SIZE; i++) {
            String generatedLine = RandomStringUtils.randomAlphanumeric(LINE_SIZE)+"\n";

            buffer.put(generatedLine.getBytes());
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        randomAccessFile.close();
        fileChannel.close();
    }

}
