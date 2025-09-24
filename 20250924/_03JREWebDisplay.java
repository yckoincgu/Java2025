import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class _03JREWebDisplay {
    public static void main(String[] args) throws IOException {
        // Create HTTP server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Create context for the root path
        server.createContext("/", new JREInfoHandler());
        
        // Start the server
        server.start();
        
        System.out.println("Server started on http://localhost:8080");
        System.out.println("Open your web browser and navigate to the above URL");
        System.out.println("Press Ctrl+C to stop the server");
    }
    
    static class JREInfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Set response headers
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, 0);
            
            // Get output stream
            OutputStream os = exchange.getResponseBody();
            
            // HTML content
            String htmlContent = createHTMLContent();
            
            // Write HTML response
            os.write(htmlContent.getBytes());
            os.close();
        }
        
        private String createHTMLContent() {
            return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Java Runtime Environment (JRE)</title>
                    <style>
                        body {
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            line-height: 1.6;
                            margin: 0;
                            padding: 20px;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            min-height: 100vh;
                        }
                        
                        .container {
                            max-width: 1000px;
                            margin: 0 auto;
                            background: white;
                            padding: 30px;
                            border-radius: 15px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                        }
                        
                        h1 {
                            color: #2c3e50;
                            text-align: center;
                            border-bottom: 3px solid #3498db;
                            padding-bottom: 10px;
                            margin-bottom: 30px;
                        }
                        
                        h2 {
                            color: #34495e;
                            margin-top: 30px;
                            border-left: 4px solid #e74c3c;
                            padding-left: 15px;
                        }
                        
                        .jre-definition {
                            background: #f8f9fa;
                            padding: 20px;
                            border-radius: 10px;
                            border-left: 5px solid #3498db;
                            margin: 20px 0;
                        }
                        
                        .component {
                            background: #fff;
                            border: 2px solid #e3e3e3;
                            border-radius: 10px;
                            padding: 20px;
                            margin: 15px 0;
                            transition: transform 0.3s ease, box-shadow 0.3s ease;
                        }
                        
                        .component:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
                        }
                        
                        .component h3 {
                            color: #e74c3c;
                            margin-top: 0;
                        }
                        
                        .highlight {
                            background: #fff3cd;
                            padding: 10px;
                            border-radius: 5px;
                            border-left: 4px solid #ffc107;
                            margin: 10px 0;
                        }
                        
                        .footer {
                            text-align: center;
                            margin-top: 40px;
                            color: #7f8c8d;
                            font-size: 0.9em;
                        }
                        
                        .java-logo {
                            text-align: center;
                            font-size: 3em;
                            color: #e74c3c;
                            margin-bottom: 20px;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="java-logo">☕</div>
                        <h1>Java Runtime Environment (JRE)</h1>
                        
                        <div class="jre-definition">
                            <p><strong>Java Runtime Environment (JRE)</strong> is a software layer that provides the necessary resources for a Java application to run successfully on a computer. It is primarily for end-users who need to execute Java programs, not develop them.</p>
                        </div>
                        
                        <h2>Key Components of the JRE</h2>
                        
                        <div class="component">
                            <h3>Java Virtual Machine (JVM)</h3>
                            <p>The core of the JRE that executes Java bytecode, the intermediate language generated by the Java compiler. It provides the <strong>"Write Once, Run Anywhere"</strong> capability by acting as a translator for the host operating system.</p>
                            <div class="highlight">
                                <strong>Function:</strong> Executes Java bytecode, provides platform independence
                            </div>
                        </div>
                        
                        <div class="component">
                            <h3>Java Class Libraries</h3>
                            <p>A vast collection of pre-written code modules that provide standard functions for tasks like file input/output, networking, and graphical user interface development.</p>
                            <div class="highlight">
                                <strong>Function:</strong> Provides ready-to-use functionality for common programming tasks
                            </div>
                        </div>
                        
                        <div class="component">
                            <h3>Class Loaders</h3>
                            <p>Dynamically load the necessary Java classes into the JVM during runtime, improving efficiency by only loading classes when they are needed.</p>
                            <div class="highlight">
                                <strong>Function:</strong> Dynamic class loading for efficient memory usage
                            </div>
                        </div>
                        
                        <div class="component">
                            <h3>Other Supporting Files</h3>
                            <p>Include configuration files and security features that enforce a <strong>"sandbox" model</strong> to prevent malicious code from accessing system resources.</p>
                            <div class="highlight">
                                <strong>Function:</strong> Security management and configuration
                            </div>
                        </div>
                        
                        <div class="highlight">
                            <strong>Note:</strong> The JRE is different from the JDK (Java Development Kit). The JDK includes the JRE plus development tools like compilers and debuggers for creating Java applications.
                        </div>
                        
                        <div class="footer">
                            <p>Java Runtime Environment Information | Generated by Java Web Server</p>
                        </div>
                    </div>
                </body>
                </html>
                """;
        }
    }
}