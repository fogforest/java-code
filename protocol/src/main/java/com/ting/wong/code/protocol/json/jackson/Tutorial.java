package com.ting.wong.code.protocol.json.jackson;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Map;

/**
 * Jackson使用范例
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/2/14
 **/
public class Tutorial {

    public static void main(String[] args) throws IOException {
        // create once, reuse
        ObjectMapper mapper = new ObjectMapper();
        Tutorial value = mapper.readValue("", Tutorial.class);

        byte[] jsonBytes = mapper.writeValueAsBytes(value);
        String jsonString = mapper.writeValueAsString(value);

        Map<String, Tutorial> results = mapper.readValue("",
                new TypeReference<Map<String, Tutorial>>() {
                });

        // can be read as generic JsonNode, if it can be Object or Array; or,
        // if known to be Object, as ObjectNode, if array, ArrayNode etc:
        ObjectNode root = (ObjectNode) mapper.readTree("stuff.json");
        String name = root.get("name").asText();
        int age = root.get("age").asInt();

        // can modify as well: this adds child Object as property 'other', set property 'type'
        root.with("other").put("type", "student");
        String json = mapper.writeValueAsString(root);

        // with above, we end up with something like as 'json' String:
        // {
        //   "name" : "Bob", "age" : 13,
        //   "other" : {
        //      "type" : "student"
        //   }
        // }


    }

}
