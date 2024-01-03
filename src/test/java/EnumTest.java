import com.sunl19ht.enums.ColorEnums;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EnumTest {
    private static final HashMap<String, Integer> hashMap = new HashMap<>();
    @Test
    public void Test() {
        readYamlFile("F:\\GoTo\\src\\main\\resources\\config.yaml");
    }

    private static void readYamlFile(String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            byte[] fileContent = Files.readAllBytes(filePath);

            // 将YAML文件内容解析为Map
            Yaml yaml = new Yaml();
            HashMap<String, Object> data = yaml.load(new String(fileContent));

            // 打印Map内容
            System.out.println("Read YAML file content:");
            System.out.println(data.get("player1").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
