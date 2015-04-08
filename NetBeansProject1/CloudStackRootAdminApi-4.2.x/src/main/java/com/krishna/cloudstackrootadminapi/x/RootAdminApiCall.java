package com.krishna.cloudstackrootadminapi.x;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.digester.Digester;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Cloud stack RootAdminApi 4.2.X to list all clusters from AssistanZ
 * demo.fogpanel.com/client
 *
 * @author Krishna <krishna.t2329@gmail.com>
 */
public class RootAdminApiCall {

    //This class implements a hash table, which maps keys to values.
    private Hashtable cluster = new Hashtable();

    public static void main(String[] args) throws IOException {

        RootAdminApiCall execute = new RootAdminApiCall();
        // Host of cloud stack 
        String host = null;
        // Command url for cloud stack api
        String apiUrl = null;
        // ApiKey of root Adminapi user
        String apiKey = null;
        //SecretKey of root Adminapi user
        String secretKey = null;

        try {
            ///home/intern/NetBeansProjects/cloud/ucloud-openapi-sample/CloudStackUser/src/UrlProperties.properties
            //ResourceBundle prop = ResourceBundle.getBundle("/home/intern/NetBeansProjects/cloud/ucloud-openapi-sample/CloudStackUser/UrlProperties.properties");
            File file = new File("C:\\Users\\sony\\Desktop\\CloudStackUser\\src\\UrlProperties.properties").getAbsoluteFile();
            FileInputStream fileInput = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fileInput);

            //host
            host = prop.getProperty("host");

            // apiUrl
            apiUrl = prop.getProperty("apiUrl");

            // apiKey
            apiKey = prop.getProperty("apiKey");

            // secretKey
            secretKey = prop.getProperty("secretKey");

            System.out.println("Constructing API call to host = '" + host + "' with API command = '" + apiUrl + "' using apiKey = '" + apiKey + "' and secretKey = '" + secretKey + "'");

            // To make the APIKey as URL encoded.
            String encodedApiKey = URLEncoder.encode(apiKey, "UTF-8");

            /**
             * Encode the Url of each parameter value and then sort the
             * parameters and apiKey in alphabetical order, and then toLowerCase
             * all the parameters, parameter values and apiKey.
             *
             */
            List<String> sortedParams = new ArrayList<String>();
            sortedParams.add("apikey=" + encodedApiKey.toLowerCase());
            StringTokenizer st = new StringTokenizer(apiUrl, "&");
            String url = null;
            boolean first = true;
            while (st.hasMoreTokens()) {
                String paramValue = st.nextToken();
                String param = paramValue.substring(0, paramValue.indexOf("="));
                String value = URLEncoder.encode(paramValue.substring(paramValue.indexOf("=") + 1, paramValue.length()), "UTF-8");
                if (first) {
                    url = param + "=" + value;
                    first = false;
                } else {
                    url = url + "&" + param + "=" + value;
                }
                sortedParams.add(param.toLowerCase() + "=" + value.toLowerCase());
            }
            Collections.sort(sortedParams);
            System.out.println("Sorted Parameters: " + sortedParams);

            //Construct the sorted URL, sign and encode the sorted URL with secret key
            String sortedUrl = null;
            first = true;
            for (String param : sortedParams) {
                if (first) {
                    sortedUrl = param;
                    first = false;
                } else {
                    sortedUrl = sortedUrl + "&" + param;
                }
            }
            System.out.println("sorted URL : " + sortedUrl);
            String encodedSignature = generateSignature(sortedUrl, secretKey);
            System.out.println("encodedSignature : " + encodedSignature);

            //Construct the final URL which has to be passed via Http GET method.
            String finalUrl = host + url + "&apiKey=" + apiKey + "&signature=" + encodedSignature;
            System.out.println("final URL : " + finalUrl);

            //Perform a HTTP GET on this URL to execute the command
            HttpClient client = new HttpClient();
            HttpMethod method = new GetMethod(finalUrl);
            int responseCode = client.executeMethod(method);

            if (responseCode == 200) {

                System.out.println(method.getResponseBodyAsString());

                String xmlString = method.getResponseBodyAsString();

                /**
                 * Defines a factory API that enables applications to obtain a
                 * parser that produces DOM object trees from XML documents.
                 *
                 */
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                /**
                 * Defines the API to obtain DOM Document instances from an XML
                 * document. Using this class, an application programmer can
                 * obtain a Document from XML.
                 */
                DocumentBuilder builder;
                try {
                    builder = factory.newDocumentBuilder();

                    /**
                     * The Document interface represents the entire HTML or XML
                     * document. Conceptually, it is the root of the document
                     * tree, and provides the primary access to the document's
                     * data.
                     */
                    Document document = builder.parse(new InputSource(
                            new StringReader(xmlString)));

                    /**
                     * A TransformerFactory instance can be used to create
                     * Transformer and Templates objects
                     */
                    TransformerFactory tranFactory = TransformerFactory.newInstance();

                    //An instance of this abstract class can transform a source tree into a result tree.
                    Transformer aTransformer = tranFactory.newTransformer();
                    Source src = new DOMSource(document);
                    Result dest = new StreamResult(new File("ListClusters.xml"));
                    aTransformer.transform(src, dest);
                } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
                }

                try {
                    //run() method calls the digeter frameWork to parse xml.
                    execute.run();
                } catch (IOException | SAXException e) {
                }

            } else {
                System.out.println("Unable to execute command with response code: " + responseCode);
            }
        } catch (IOException | TransformerFactoryConfigurationError t) {
            System.out.println(t);
        }
    }

    private void run() throws IOException, SAXException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //The Digester package configure an XML -> Java object mapping module.
        Digester digester = new Digester();

        digester.push(this);

        digester.addCallMethod("listclustersresponse/cluster", "addCluster", 12);
        digester.addCallParam("listclustersresponse/cluster/id", 0);
        digester.addCallParam("listclustersresponse/cluster/name", 1);
        digester.addCallParam("listclustersresponse/cluster/podid", 2);
        digester.addCallParam("listclustersresponse/cluster/podname", 3);
        digester.addCallParam("listclustersresponse/cluster/zoneid", 4);
        digester.addCallParam("listclustersresponse/cluster/zonename", 5);
        digester.addCallParam("listclustersresponse/cluster/hypervisortype", 6);
        digester.addCallParam("listclustersresponse/cluster/clustertype", 7);
        digester.addCallParam("listclustersresponse/cluster/allocationstate", 8);
        digester.addCallParam("listclustersresponse/cluster/managedstate", 9);
        digester.addCallParam("listclustersresponse/cluster/cpuovercommitratio", 10);
        digester.addCallParam("listclustersresponse/cluster/memoryovercommitratio", 11);

        digester.parse("listClusters.xml");
    }

    public void addCluster(String id, String name, String podid, String podname, String zoneid, String zonename, String hypervisorType, String clusterType, String allocationState, String managedState, String cpuOverCommitRatio, String memoryOverCommitRatio) {
        ListClusters listClusters = new ListClusters(id, name, podid, podname, zoneid, zonename, hypervisorType, clusterType, allocationState, managedState, cpuOverCommitRatio, memoryOverCommitRatio);
        cluster.put(id, listClusters);
        cluster.put(name, listClusters);
        cluster.put(podid, listClusters);
        cluster.put(podname, listClusters);
        cluster.put(zoneid, listClusters);
        cluster.put(zonename, listClusters);
        cluster.put(hypervisorType, listClusters);
        cluster.put(clusterType, listClusters);
        cluster.put(allocationState, listClusters);
        cluster.put(managedState, listClusters);
        cluster.put(cpuOverCommitRatio, listClusters);
        cluster.put(memoryOverCommitRatio, listClusters);

        System.out.println("ListCluster id: " + id);
        System.out.println("ListCluster name: " + name);
        System.out.println("ListCluster podId: " + podid);
        System.out.println("ListCluster podName: " + podname);
        System.out.println("ListCluster ZoneId: " + zoneid);
        System.out.println("ListCluster zoneName: " + zonename);
        System.out.println("ListCluster hyperVisorType: " + hypervisorType);
        System.out.println("ListCluster clusterType: " + clusterType);
        System.out.println("ListCluster allocationState: " + allocationState);
        System.out.println("ListCluster managedState: " + managedState);
        System.out.println("ListCluster cpuOverCommitRatio: " + cpuOverCommitRatio);
        System.out.println("ListCluster memoryOverCommitRatio: " + memoryOverCommitRatio);
    }

    /**
     * Signs a string with a secret key using SHA-1 Base64 encode the result URL
     * encode the final result
     *
     * @param request
     * @param key
     * @return
     */
    public static String generateSignature(String request, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            mac.init(keySpec);
            mac.update(request.getBytes());
            byte[] encryptedBytes = mac.doFinal();
            return URLEncoder.encode(Base64.encodeBytes(encryptedBytes), "UTF-8");
        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalStateException | UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
