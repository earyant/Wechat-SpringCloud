//package com.earyant.wechat.util;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonParser.Feature;
//import com.fasterxml.jackson.core.io.CharacterEscapes;
//import com.fasterxml.jackson.core.io.SerializedString;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.type.TypeFactory;
//import org.codehaus.jackson.type.TypeReference;
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.*;
//
///**
// * Json工具类
// */
//public class JsonStringUtils {
//
//    private static Logger logger = Logger.getLogger(JsonStringUtils.class.getName());
//
//    private static HtmlCharacterEscapes hce = new HtmlCharacterEscapes();
//
//    /**
//     * list 转换 json string
//     *
//     * @param <T>
//     * @param ls
//     * @return String
//     */
//    public static <T> String listToJsonString(List<T> ls) {
//        String json = "";
//        JsonGenerator jgen = null;
//        ObjectMapper mapper = new ObjectMapper();
//        StringWriter sw = new StringWriter();
//
//        try {
//            jgen = new JsonFactory().createJsonGenerator(sw);
//            mapper.writeValue(jgen, ls);
//            json = sw.toString();
//            jgen.flush();
//        } catch (JsonGenerationException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } finally {
//            try {
//                jgen.close();
//                jgen = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//            try {
//                sw.close();
//                sw = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//        }
//        return json;
//    }
//
//    /**
//     * 根据传入的对象 生成json字符串
//     *
//     * @param <T>
//     * @param t
//     * @return String
//     */
//    public static <T> String objectToJsonString(T t) {
//        String json = "";
//        JsonGenerator jgen = null;
//        ObjectMapper mapper = new ObjectMapper();
//        StringWriter sw = new StringWriter();
//
//        try {
//            jgen = new JsonFactory().createJsonGenerator(sw);
//            mapper.writeValue(jgen, t);
//            json = sw.toString();
//            jgen.flush();
//        } catch (JsonGenerationException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } finally {
//            try {
//                jgen.close();
//                jgen = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//            try {
//                sw.close();
//                sw = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//        }
//        return json;
//    }
//
//    /**
//     * 转换HTML 特殊字符
//     *
//     * @param t
//     * @return
//     */
//    public static <T> String objectToJsonStringEscapes(T t) {
//        String json = "";
//        JsonGenerator jgen = null;
//        ObjectMapper mapper = new ObjectMapper();
//        StringWriter sw = new StringWriter();
//
//        try {
//            jgen = new JsonFactory().setCharacterEscapes(hce).createJsonGenerator(sw);
//            mapper.writeValue(jgen, t);
//            json = sw.toString();
//            jgen.flush();
//        } catch (JsonGenerationException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } finally {
//            try {
//                jgen.close();
//                jgen = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//            try {
//                sw.close();
//                sw = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//        }
//        return json;
//    }
//
//    /**
//     * 转换HTML 特殊字符
//     *
//     * @param ls
//     * @return
//     */
//    public static <T> String listToJsonStringEscapes(List<T> ls) {
//        String json = "";
//        JsonGenerator jgen = null;
//        ObjectMapper mapper = new ObjectMapper();
//        StringWriter sw = new StringWriter();
//
//        try {
//            jgen = new JsonFactory().setCharacterEscapes(hce).createJsonGenerator(sw);
//            mapper.writeValue(jgen, ls);
//            json = sw.toString();
//            jgen.flush();
//        } catch (JsonGenerationException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//        } finally {
//            try {
//                jgen.close();
//                jgen = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//            try {
//                sw.close();
//                sw = null;
//            } catch (IOException e) {
//                logger.error("JsonStringUtils " + e.getMessage());
//            }
//        }
//        return json;
//    }
//
//    /**
//     * 根据JSON 字符串 返回 POJO
//     * 例如：Goods a = JsonStringUtils.jsonStringToObject(jsonString, Goods.class);
//     *
//     * @param <T>
//     * @param jsonString json 格式字符串
//     * @param clazz      Object.class
//     * @return T
//     * @throws Exception
//     */
//    public static <T> T jsonStringToObject(String jsonString, Class<T> clazz) throws Exception {
//        T t = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            if (StringUtils.isNotEmpty(jsonString)) {
//                t = mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue(jsonString, clazz);
//            }
//        } catch (JsonParseException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        }
//        return t;
//    }
//
//    /**
//     * 将json解析成map
//     *
//     * @return
//     * @throws Exception
//     * @author 韩志伟 2016-4-6
//     */
//    @SuppressWarnings("unchecked")
//    public static Map<String, String> parserJsonToMap(String jsonString) throws Exception {
//        Map<String, String> ls = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            if (StringUtils.isNotEmpty(jsonString)) {
//                ls = mapper.readValue(
//                        jsonString, Map.class);
////				Map<String, Map<String, Object>> maps = mapper.readValue(
////						jsonString, Map.class);
//                System.out.println(ls.size());
//                Set<String> key = ls.keySet();
//                Iterator<String> iter = key.iterator();
//                while (iter.hasNext()) {
//                    String field = iter.next();
//                    System.out.println(field + ":" + ls.get(field));
//                }
//            }
//        } catch (JsonParseException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        }
//        return ls;
//    }
//
//    /**
//     * 返回 List Map 封装对象 List<Map<String, String>>;
//     * List<Map<String, String>> ls = JsonStringUtils.jsonStringToList(jsonString);
//     *
//     * @param jsonString json格式字符串
//     * @return List<Map<String, String>>
//     * @throws Exception
//     */
//    public static List<Map<String, String>> jsonStringToList(String jsonString) throws Exception {
//        List<Map<String, String>> ls = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            if (StringUtils.isNotEmpty(jsonString)) {
//                ls = mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue(jsonString, new TypeReference<List<Map<String, String>>>() {
//                });
//            }
//        } catch (JsonParseException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        }
//        return ls;
//    }
//
//    /**
//     * 根据 JSON 字符串 返回 LIST 对象，LIST ELEMENT 为 POJO || VO
//     * List<Goods> lsa = JsonStringUtils.jsonStringToList(jsonString, Goods.class);
//     *
//     * @param <T>
//     * @param jsonString
//     * @param cl
//     * @return List<T>
//     * @throws Exception
//     */
//    public static <T> List<T> jsonStringToList(String jsonString, Class<T> cl) throws Exception {
//        List<T> ls = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            if (StringUtils.isNotEmpty(jsonString)) {
//                ls = mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, cl));
//            }
//        } catch (JsonParseException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        }
//        return ls;
//    }
//
//
//    /**
//     * 根据 JSON 字符串 返回 LIST 对象，LIST ELEMENT 为 POJO || VO
//     * List<Goods> lsa = JsonStringUtils.jsonStringToList(jsonString, Goods.class);
//     *
//     * @return List<T>
//     * @throws Exception
//     */
//    public static List<String> jsonStringToListString(String jsonString) throws Exception {
//        List<String> ls = null;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            if (StringUtils.isNotEmpty(jsonString)) {
//                ls = mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue(jsonString, new TypeReference<List<String>>() {
//                });
//            }
//        } catch (JsonParseException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (JsonMappingException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        } catch (IOException e) {
//            logger.error("JsonStringUtils " + e.getMessage());
//            throw new Exception(e);
//        }
//        return ls;
//    }
//
//
//    /**
//     * 根据 JSON 字符串 返回 LIST 对象，LIST ELEMENT 为 POJO || VO 此方法保留，
//     * 不推荐使用，此方法由 jsonStringToList(String jsonString, Class<T> cl) 方法替换
//     * 例如：List<Goods> lsa = JsonStringUtils.fromJsonStringList(jsonString, Goods.class);
//     *
//     * @param <T>
//     * @param jsonString 符合规则的字符串
//     * @param cl         POJO CLASS
//     * @return List<T>
//     * @throws Exception
//     * @deprecated
//     */
//    public static <T> List<T> fromJsonStringList(String jsonString, Class<T> cl) throws Exception {
//        List<T> ls = new ArrayList<T>();
//        if (StringUtils.isNotEmpty(jsonString)) {
//            List<Map<String, String>> lsm = JsonStringUtils.jsonStringToList(jsonString);
//            if (lsm != null) {
//                for (Map<String, String> m : lsm) {
//                    T t = cl.newInstance();
//                    BeanUtils.populate(t, m);
//                    ls.add(t);
//                }
//            }
//        }
//        return ls;
//    }
//
//    private static class HtmlCharacterEscapes extends CharacterEscapes {
//
//        private final int[] asciiEscapes;
//
//        public HtmlCharacterEscapes() {
//            int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
//            esc['<'] = CharacterEscapes.ESCAPE_CUSTOM;
//            esc['>'] = CharacterEscapes.ESCAPE_CUSTOM;
//            esc['&'] = CharacterEscapes.ESCAPE_CUSTOM;
//            esc['\''] = CharacterEscapes.ESCAPE_CUSTOM;
//            esc['"'] = CharacterEscapes.ESCAPE_CUSTOM;
//            asciiEscapes = esc;
//        }
//
//        @Override
//        public int[] getEscapeCodesForAscii() {
//            return asciiEscapes;
//        }
//
//        @Override
//        public SerializableString getEscapeSequence(int ch) {
//            return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString((char) ch)));
//        }
//    }
//}