package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static PresentationTools presentationTools = new PresentationTools();
    public static void main(String[] args) {

       //Stdio server transport
        var transportProvider = new StdioServerTransportProvider(new ObjectMapper());

        //Sync tool specificatio
        var syncToolSpecification = getSyncToolSpecification();

        McpServer.sync(transportProvider)
                .serverInfo("javaone-mcp","0.0,1")
                .capabilities(McpSchema.ServerCapabilities.builder()
                        .tools(true)
                        .logging()
                        .build())
                .tools(syncToolSpecification)
                .build();

        log.info("Starting Server ...");
    }

    private static McpServerFeatures.SyncToolSpecification getSyncToolSpecification() {
        var schema = """
            {
              "type" : "object",
              "id" : "urn:jsonschema:Operation",
              "properties" : {
                "operation" : {
                  "type" : "string"
                }
              }
            }
            """;
        var syncToolSpecification = new McpServerFeatures.SyncToolSpecification(
                new McpSchema.Tool("get_presentations", "Get a list of all presentations from JavaOne", schema),
                (exchange, arguments) -> {
                    // Tool implementation
                    List<Presentation> presentations = presentationTools.getPresentations();
                    List<McpSchema.Content> contents = new ArrayList<>();
                    for (Presentation presentation : presentations) {
                        contents.add(new McpSchema.TextContent(presentation.toString()));
                    }
                    return new McpSchema.CallToolResult(contents, false);
                }
        );
        return syncToolSpecification;
    }
}