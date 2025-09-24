import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class _06CompilationVsPackageServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new ComparisonHandler());
        server.start();
        
        System.out.println("✅ Compilation vs Package Comparison Server Started!");
        System.out.println("🌐 Open: http://localhost:8080");
        System.out.println("⏹️  Press Ctrl+C to stop");
    }
    
    static class ComparisonHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = createComparisonPage();
            
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        
        private String createComparisonPage() {
            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Compilation vs Package - Java Comparison</title>
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }
                        
                        body {
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            line-height: 1.6;
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            min-height: 100vh;
                            padding: 20px;
                            color: #333;
                        }
                        
                        .container {
                            max-width: 1400px;
                            margin: 0 auto;
                        }
                        
                        .header {
                            background: linear-gradient(135deg, #2c3e50 0%, #34495e 100%);
                            color: white;
                            padding: 40px;
                            border-radius: 15px 15px 0 0;
                            text-align: center;
                            margin-bottom: 0;
                        }
                        
                        .main-content {
                            background: white;
                            border-radius: 0 0 15px 15px;
                            padding: 40px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                        }
                        
                        h1 {
                            font-size: 2.8em;
                            margin-bottom: 10px;
                            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
                        }
                        
                        .subtitle {
                            font-size: 1.3em;
                            opacity: 0.9;
                            margin-bottom: 20px;
                        }
                        
                        .nav {
                            display: flex;
                            justify-content: center;
                            gap: 15px;
                            margin: 30px 0;
                            flex-wrap: wrap;
                        }
                        
                        .nav a {
                            background: #3498db;
                            color: white;
                            padding: 12px 25px;
                            text-decoration: none;
                            border-radius: 25px;
                            transition: all 0.3s ease;
                            font-weight: bold;
                        }
                        
                        .nav a:hover {
                            background: #2980b9;
                            transform: translateY(-2px);
                        }
                        
                        .comparison-grid {
                            display: grid;
                            grid-template-columns: 1fr 1fr;
                            gap: 30px;
                            margin: 40px 0;
                        }
                        
                        .card {
                            background: #f8f9fa;
                            border-radius: 10px;
                            padding: 30px;
                            border-left: 5px solid #3498db;
                            transition: transform 0.3s ease;
                        }
                        
                        .compilation-card {
                            border-left-color: #e74c3c;
                        }
                        
                        .package-card {
                            border-left-color: #2ecc71;
                        }
                        
                        .card:hover {
                            transform: translateY(-5px);
                        }
                        
                        .card h2 {
                            color: #2c3e50;
                            margin-bottom: 20px;
                            display: flex;
                            align-items: center;
                            gap: 10px;
                        }
                        
                        .feature-list {
                            list-style: none;
                            margin: 20px 0;
                        }
                        
                        .feature-list li {
                            padding: 10px 0;
                            border-bottom: 1px solid #e3e3e3;
                            display: flex;
                            align-items: center;
                            gap: 10px;
                        }
                        
                        .feature-list li:before {
                            content: "✓";
                            color: #27ae60;
                            font-weight: bold;
                        }
                        
                        .code-block {
                            background: #2c3e50;
                            color: #ecf0f1;
                            padding: 20px;
                            border-radius: 8px;
                            margin: 15px 0;
                            font-family: 'Courier New', monospace;
                            font-size: 14px;
                            line-height: 1.4;
                        }
                        
                        .comparison-table {
                            width: 100%;
                            border-collapse: collapse;
                            margin: 30px 0;
                            background: white;
                            border-radius: 8px;
                            overflow: hidden;
                            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
                        }
                        
                        .comparison-table th {
                            background: #34495e;
                            color: white;
                            padding: 15px;
                            text-align: left;
                        }
                        
                        .comparison-table td {
                            padding: 15px;
                            border-bottom: 1px solid #ecf0f1;
                        }
                        
                        .comparison-table tr:nth-child(even) {
                            background: #f8f9fa;
                        }
                        
                        .highlight {
                            background: #fff3cd;
                            padding: 20px;
                            border-radius: 8px;
                            margin: 20px 0;
                            border-left: 4px solid #ffc107;
                        }
                        
                        .workflow {
                            background: #e8f4fc;
                            padding: 25px;
                            border-radius: 10px;
                            margin: 30px 0;
                            border-left: 5px solid #3498db;
                        }
                        
                        .workflow-step {
                            display: flex;
                            align-items: center;
                            margin: 15px 0;
                            padding: 10px;
                            background: white;
                            border-radius: 5px;
                        }
                        
                        .step-number {
                            background: #3498db;
                            color: white;
                            width: 30px;
                            height: 30px;
                            border-radius: 50%;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            margin-right: 15px;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="header">
                            <h1>⚙️ Compilation vs 📦 Packages</h1>
                            <div class="subtitle">Understanding the Fundamental Concepts in Java</div>
                        </div>
                        
                        <div class="main-content">
                            <div class="nav">
                                <a href="#comparison">Comparison Table</a>
                                <a href="#compilation">Compilation Process</a>
                                <a href="#packages">Package System</a>
                                <a href="#workflow">Complete Workflow</a>
                            </div>
                            
                            <div class="highlight">
                                <strong>🎯 Key Insight:</strong> Compilation and packages serve different but complementary purposes in Java. 
                                Compilation is about <em>transforming code</em>, while packages are about <em>organizing code</em>.
                            </div>
                            
                            <div id="comparison">
                                <h2>📊 Comprehensive Comparison</h2>
                                <table class="comparison-table">
                                    <tr>
                                        <th>Aspect</th>
                                        <th>Compilation</th>
                                        <th>Packages</th>
                                    </tr>
                                    <tr>
                                        <td><strong>Purpose</strong></td>
                                        <td>Convert source code to bytecode</td>
                                        <td>Organize and namespace classes</td>
                                    </tr>
                                    <tr>
                                        <td><strong>When it happens</strong></td>
                                        <td>Development time (before execution)</td>
                                        <td>Design time (code organization)</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Primary Tool</strong></td>
                                        <td>javac (Java Compiler)</td>
                                        <td>package keyword + directory structure</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Input</strong></td>
                                        <td>.java source files</td>
                                        <td>Java classes/interfaces</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Output</strong></td>
                                        <td>.class bytecode files</td>
                                        <td>Logical grouping hierarchy</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Platform Dependency</strong></td>
                                        <td>Platform-independent bytecode</td>
                                        <td>Platform-independent organization</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Error Checking</strong></td>
                                        <td>Syntax, type checking, semantic analysis</td>
                                        <td>Namespace conflict detection</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Dependency Management</strong></td>
                                        <td>Compile-time dependencies</td>
                                        <td>Import statements, classpath</td>
                                    </tr>
                                </table>
                            </div>
                            
                            <div class="comparison-grid">
                                <div class="card compilation-card">
                                    <h2>⚙️ Compilation Process</h2>
                                    <p><strong>Definition:</strong> The process of translating Java source code (.java) into platform-independent bytecode (.class)</p>
                                    
                                    <div class="code-block">
                                        // Compilation Command<br>
                                        javac MyProgram.java<br>
                                        // Produces: MyProgram.class
                                    </div>
                                    
                                    <h3>🔧 Compilation Steps:</h3>
                                    <ul class="feature-list">
                                        <li><strong>Lexical Analysis:</strong> Break code into tokens</li>
                                        <li><strong>Syntax Analysis:</strong> Build Abstract Syntax Tree (AST)</li>
                                        <li><strong>Semantic Analysis:</strong> Type checking, symbol resolution</li>
                                        <li><strong>Code Generation:</strong> Produce bytecode</li>
                                        <li><strong>Optimization:</strong> Improve performance (optional)</li>
                                    </ul>
                                    
                                    <h3>📝 Example:</h3>
                                    <div class="code-block">
                                        // Source: Calculator.java<br>
                                        public class Calculator {<br>
                                        &nbsp;&nbsp;&nbsp;public int add(int a, int b) {<br>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return a + b;<br>
                                        &nbsp;&nbsp;&nbsp;}<br>
                                        }<br>
                                        <br>
                                        // After compilation: Calculator.class (bytecode)
                                    </div>
                                </div>
                                
                                <div class="card package-card">
                                    <h2>📦 Package System</h2>
                                    <p><strong>Definition:</strong> A mechanism for organizing related classes and interfaces into namespaces</p>
                                    
                                    <div class="code-block">
                                        // Package Declaration<br>
                                        package com.example.myapp;<br>
                                        <br>
                                        // Import Statement<br>
                                        import java.util.ArrayList;
                                    </div>
                                    
                                    <h3>🎯 Package Benefits:</h3>
                                    <ul class="feature-list">
                                        <li><strong>Organization:</strong> Logical grouping of classes</li>
                                        <li><strong>Namespace Management:</strong> Avoid naming conflicts</li>
                                        <li><strong>Access Control:</strong> Package-private visibility</li>
                                        <li><strong>Reusability:</strong> Modular code organization</li>
                                        <li><strong>Maintenance:</strong> Easier to locate and manage code</li>
                                    </ul>
                                    
                                    <h3>📝 Example:</h3>
                                    <div class="code-block">
                                        // File: com/example/utils/StringHelper.java<br>
                                        package com.example.utils;<br>
                                        <br>
                                        public class StringHelper {<br>
                                        &nbsp;&nbsp;&nbsp;public static boolean isEmpty(String str) {<br>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return str == null || str.isEmpty();<br>
                                        &nbsp;&nbsp;&nbsp;}<br>
                                        }
                                    </div>
                                </div>
                            </div>
                            
                            <div id="workflow" class="workflow">
                                <h2>🔄 Complete Development Workflow</h2>
                                <p>How compilation and packages work together in a typical Java project:</p>
                                
                                <div class="workflow-step">
                                    <div class="step-number">1</div>
                                    <div>
                                        <strong>Write Source Code</strong><br>
                                        Create .java files with package declarations
                                    </div>
                                </div>
                                
                                <div class="workflow-step">
                                    <div class="step-number">2</div>
                                    <div>
                                        <strong>Organize in Directories</strong><br>
                                        Match package structure with directory structure
                                    </div>
                                </div>
                                
                                <div class="workflow-step">
                                    <div class="step-number">3</div>
                                    <div>
                                        <strong>Compile</strong><br>
                                        javac command processes all .java files
                                    </div>
                                </div>
                                
                                <div class="workflow-step">
                                    <div class="step-number">4</div>
                                    <div>
                                        <strong>Generate .class files</strong><br>
                                        Bytecode files maintain package structure
                                    </div>
                                </div>
                                
                                <div class="workflow-step">
                                    <div class="step-number">5</div>
                                    <div>
                                        <strong>Package into JAR</strong><br>
                                        Optional step to bundle compiled classes
                                    </div>
                                </div>
                                
                                <div class="code-block">
                                    // Project Structure<br>
                                    src/<br>
                                    └── com/<br>
                                        └── example/<br>
                                            └── myapp/<br>
                                                ├── Main.java<br>
                                                └── utils/<br>
                                                    └── StringHelper.java<br>
                                    <br>
                                    // Compilation Command<br>
                                    javac -d bin src/com/example/myapp/*.java src/com/example/myapp/utils/*.java
                                </div>
                            </div>
                            
                            <div class="comparison-grid">
                                <div class="card">
                                    <h2>⚠️ Common Compilation Issues</h2>
                                    <ul class="feature-list">
                                        <li><strong>Syntax Errors:</strong> Missing semicolons, brackets</li>
                                        <li><strong>Type Mismatches:</strong> Incompatible data types</li>
                                        <li><strong>Missing Dependencies:</strong> Classes not on classpath</li>
                                        <li><strong>Access Violations:</strong> Trying to access private members</li>
                                        <li><strong>Resource Errors:</strong> Missing files, IO problems</li>
                                    </ul>
                                </div>
                                
                                <div class="card">
                                    <h2>⚠️ Common Package Issues</h2>
                                    <ul class="feature-list">
                                        <li><strong>Naming Conflicts:</strong> Same class name in different packages</li>
                                        <li><strong>Import Errors:</strong> Wrong import statements</li>
                                        <li><strong>Directory Mismatch:</strong> Package doesn't match folder structure</li>
                                        <li><strong>Classpath Issues:</strong> Packages not found at runtime</li>
                                        <li><strong>Access Problems:</strong> Package-private visibility issues</li>
                                    </ul>
                                </div>
                            </div>
                            
                            <div class="highlight">
                                <h3>💡 Best Practices</h3>
                                <p><strong>For Compilation:</strong> Use build tools (Maven, Gradle), enable all warnings, use consistent Java version</p>
                                <p><strong>For Packages:</strong> Use reverse domain naming, keep packages focused, avoid deep nesting</p>
                            </div>
                        </div>
                    </div>
                </body>
                </html>
                """;
        }
    }
}