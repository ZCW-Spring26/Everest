package rocks.zipcode.everest.format;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Formats JSON strings using Jackson's ObjectMapper.
 */
public class JSONFormatter implements Formatter {
    private static ObjectMapper mapper;

    JSONFormatter() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @Override
    public String format(String unformatted) throws IOException {
        JsonNode tree = mapper.readTree(unformatted);
        return mapper.writeValueAsString(tree);
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
