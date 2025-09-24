import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class _04JVMWebServer {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new JVMHandler());
            server.start();
            
            System.out.println("✅ JVM Web Server started successfully!");
            System.out.println("🌐 Main Page: http://localhost:8080");
            System.out.println("🏗️  Architecture: http://localhost:8080/architecture");
            System.out.println("⚡ Execution Flow: http://localhost:8080/execution");
            System.out.println("💾 Memory Management: http://localhost:8080/memory");
            
        } catch (IOException e) {
            System.err.println("❌ Server error: " + e.getMessage());
            System.err.println("💡 Try: netstat -ano | findstr 8080 (Windows) or lsof -i :8080 (Mac/Linux) to check if port is busy");
        }
    }
    
    static class JVMHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            String response = "";
            
            switch (path) {
                case "/architecture":
                    response = createArchitecturePage();
                    break;
                case "/execution":
                    response = createExecutionFlowPage();
                    break;
                case "/memory":
                    response = createMemoryPage();
                    break;
                default:
                    response = createMainPage();
                    break;
            }
            
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        
        private String createExecutionFlowPage() {
            String executionDiagram = """
                <pre style="background: #2c3e50; color: #ecf0f1; padding: 20px; border-radius: 10px; font-family: 'Courier New', monospace; font-size: 14px; line-height: 1.3;">
┌─────────────────────────────────────────────────────────────────────────────┐
│                      JVM EXECUTION FLOW - DYNAMIC PROCESS                   │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│  COMPILATION│    │  CLASS      │    │  BYTECODE   │    │  EXECUTION  │
│   PHASE     │    │  LOADING    │    │ VERIFICATION│    │   ENGINE    │
├─────────────┤    ├─────────────┤    ├─────────────┤    ├─────────────┤
│ Hello.java  │    │ Hello.class │    │   Security  │    │ Interpreter │
│     ↓       │    │     ↓       │    │    Checks   │    │     ↓       │
│   javac     │    │ ClassLoader │    │  Type Verify│    │  JIT Compiler│
│     ↓       │    │     ↓       │    │     ↓       │    │     ↓       │
│ Hello.class │───→│ JVM Memory  │───→│ Valid Code  │───→│ Native Code │
└─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘
       │                   │                   │                   │
       │                   │                   │                   │
  Before Execution    Loading Time        Security Phase      Runtime Execution

┌─────────────────────────────────────────────────────────────────────────────┐
│                          RUNTIME MEMORY MANAGEMENT                         │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│   OBJECT    │    │  HEAP       │    │  GARBAGE    │    │  MEMORY     │
│  CREATION   │    │ ALLOCATION  │    │ COLLECTION  │    │  RECLAIMED  │
├─────────────┤    ├─────────────┤    ├─────────────┤    ├─────────────┤
│  new Object()│   │  Eden Space │    │  Mark       │    │  Free       │
│     ↓       │    │     ↓       │    │  Sweep      │    │  Memory     │
│ Constructor │    │ Survivor    │    │  Compact    │    │     ↓       │
│     ↓       │    │     ↓       │    │     ↓       │    │ Reusable    │
│  Reference  │───→│ Old Generation│──→│ Unused     │───→│ for new     │
└─────────────┘    └─────────────┘    │  Objects   │    │  Objects    │
                                      └─────────────┘    └─────────────┘

┌─────────────────────────────────────────────────────────────────────────────┐
│                          METHOD EXECUTION FLOW                             │
└─────────────────────────────────────────────────────────────────────────────┐

┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│  METHOD     │    │  STACK      │    │  BYTECODE   │    │  STACK      │
│   CALL      │    │  FRAME      │    │ EXECUTION   │    │  CLEANUP    │
├─────────────┤    ├─────────────┤    ├─────────────┤    ├─────────────┤
│ myMethod()  │    │ Create      │    │ Execute     │    │ Destroy     │
│     ↓       │    │ Frame       │    │ Instructions│    │ Frame       │
│ Parameters  │    │ Local Vars  │    │ Return      │    │ Return      │
│     ↓       │    │ Operand     │    │ Value       │    │ Control     │
│  Push Stack │───→│ Stack       │───→│ Pop Stack   │───→│ to Caller   │
└─────────────┘    └─────────────┘    └─────────────┘    └─────────────┘

                </pre>
                """;

            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>JVM Execution Flow</title>
                    <style>
                        body { 
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
                            margin: 0; 
                            padding: 20px; 
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            min-height: 100vh;
                        }
                        .container { 
                            max-width: 1200px; 
                            margin: 0 auto; 
                            background: white; 
                            padding: 30px; 
                            border-radius: 15px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                        }
                        .nav { 
                            margin: 20px 0; 
                            text-align: center;
                        }
                        .nav a { 
                            display: inline-block; 
                            padding: 12px 25px; 
                            background: #3498db; 
                            color: white; 
                            text-decoration: none; 
                            margin: 5px; 
                            border-radius: 25px;
                            transition: all 0.3s ease;
                            font-weight: bold;
                        }
                        .nav a:hover {
                            background: #2980b9;
                            transform: translateY(-2px);
                        }
                        .current-page {
                            background: #e74c3c !important;
                        }
                        h1 { 
                            color: #2c3e50; 
                            text-align: center;
                            margin-bottom: 30px;
                        }
                        .step { 
                            background: #f8f9fa; 
                            padding: 25px; 
                            margin: 20px 0; 
                            border-radius: 10px;
                            border-left: 5px solid #3498db;
                        }
                        .step h3 {
                            color: #e74c3c;
                            margin-top: 0;
                        }
                        .info-box {
                            background: #fff3cd;
                            padding: 20px;
                            border-radius: 8px;
                            margin: 20px 0;
                            border-left: 4px solid #ffc107;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>⚡ JVM Execution Flow - Dynamic Process</h1>
                        
                        <div class="nav">
                            <a href="/">🏠 Home</a>
                            <a href="/architecture">🏗️ Architecture</a>
                            <a href="/execution" class="current-page">⚡ Execution Flow</a>
                            <a href="/memory">💾 Memory</a>
                        </div>
                        
                        <div class="info-box">
                            <strong>📖 Definition:</strong> The execution flow shows the <em>dynamic sequence</em> of how Java code runs from compilation to termination, 
                            contrasting with the static architecture which shows component structure.
                        </div>
                        
                        """ + executionDiagram + """
                        
                        <div class="step">
                            <h3>🔹 Step 1: Compilation Phase</h3>
                            <p><strong>Java Source (.java) → javac Compiler → Bytecode (.class)</strong></p>
                            <p>Your human-readable code is transformed into platform-independent bytecode instructions.</p>
                        </div>
                        
                        <div class="step">
                            <h3>🔹 Step 2: Class Loading Phase</h3>
                            <p><strong>Loading → Linking → Initialization</strong></p>
                            <ul>
                                <li><strong>Loading:</strong> Read .class file bytes</li>
                                <li><strong>Linking:</strong> Verify, prepare, resolve references</li>
                                <li><strong>Initialization:</strong> Execute static initializers</li>
                            </ul>
                        </div>
                        
                        <div class="step">
                            <h3>🔹 Step 3: Execution Engine Processing</h3>
                            <p><strong>Interpreter → JIT Compiler → Native Code</strong></p>
                            <ul>
                                <li><strong>Interpreter:</strong> Immediate execution, line by line</li>
                                <li><strong>JIT Compiler:</strong> Optimizes hot spots to native code</li>
                                <li><strong>Adaptive optimization:</strong> Continuous performance improvement</li>
                            </ul>
                        </div>
                        
                        <div class="step">
                            <h3>🔹 Step 4: Runtime Memory Management</h3>
                            <p><strong>Object Lifecycle: Creation → Usage → Garbage Collection</strong></p>
                            <ul>
                                <li><strong>Young Generation:</strong> New objects in Eden space</li>
                                <li><strong>Survivor Spaces:</strong> Objects that survive minor GC</li>
                                <li><strong>Old Generation:</strong> Long-lived objects</li>
                                <li><strong>Garbage Collection:</strong> Automatic memory reclamation</li>
                            </ul>
                        </div>
                        
                        <div class="step">
                            <h3>🔹 Step 5: Method Execution Cycle</h3>
                            <p><strong>Call → Frame Creation → Execution → Frame Cleanup</strong></p>
                            <p>Each method call creates a stack frame containing local variables and execution context.</p>
                        </div>
                        
                        <div class="info-box">
                            <strong>🎯 Key Insight:</strong> The JVM execution flow is <em>adaptive</em> - it monitors program behavior 
                            and optimizes performance dynamically through JIT compilation and garbage collection tuning.
                        </div>
                    </div>
                </body>
                </html>
                """;
        }
        
        private String createArchitecturePage() {
            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>JVM Architecture</title>
                    <style>
                        body { 
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
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
                        .nav { 
                            margin: 20px 0; 
                            text-align: center;
                        }
                        .nav a { 
                            display: inline-block; 
                            padding: 12px 25px; 
                            background: #3498db; 
                            color: white; 
                            text-decoration: none; 
                            margin: 5px; 
                            border-radius: 25px;
                            transition: all 0.3s ease;
                            font-weight: bold;
                        }
                        .nav a:hover {
                            background: #2980b9;
                            transform: translateY(-2px);
                        }
                        .current-page {
                            background: #e74c3c !important;
                        }
                        .component {
                            background: #f8f9fa;
                            padding: 25px;
                            margin: 20px 0;
                            border-radius: 10px;
                            border: 2px solid #e3e3e3;
                            transition: all 0.3s ease;
                        }
                        .component:hover {
                            transform: translateY(-2px);
                            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
                        }
                        h1 { color: #2c3e50; text-align: center; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>🏗️ JVM Architecture - Static Components</h1>
                        
                        <div class="nav">
                            <a href="/">🏠 Home</a>
                            <a href="/architecture" class="current-page">🏗️ Architecture</a>
                            <a href="/execution">⚡ Execution Flow</a>
                            <a href="/memory">💾 Memory</a>
                        </div>
                        
                        <div class="component">
                            <h3>1. Class Loader Subsystem</h3>
                            <p><strong>Purpose:</strong> Loads, links, and initializes classes</p>
                            <ul>
                                <li><strong>Loading:</strong> Reads .class files</li>
                                <li><strong>Linking:</strong> Verification, preparation, resolution</li>
                                <li><strong>Initialization:</strong> Static variable initialization</li>
                            </ul>
                        </div>
                        
                        <div class="component">
                            <h3>2. Runtime Data Areas (Memory Structure)</h3>
                            <p><strong>Purpose:</strong> Memory allocation for program execution</p>
                            <ul>
                                <li><strong>Method Area:</strong> Class metadata, static variables</li>
                                <li><strong>Heap:</strong> Object storage (Young/Old generations)</li>
                                <li><strong>Stack:</strong> Method calls, local variables</li>
                                <li><strong>PC Registers:</strong> Thread execution pointers</li>
                                <li><strong>Native Method Stack:</strong> Native library calls</li>
                            </ul>
                        </div>
                        
                        <div class="component">
                            <h3>3. Execution Engine</h3>
                            <p><strong>Purpose:</strong> Executes the bytecode</p>
                            <ul>
                                <li><strong>Interpreter:</strong> Reads and executes bytecode line by line</li>
                                <li><strong>JIT Compiler:</strong> Compiles frequent code to native code</li>
                                <li><strong>Garbage Collector:</strong> Automatic memory management</li>
                            </ul>
                        </div>
                    </div>
                </body>
                </html>
                """;
        }
        
        private String createMemoryPage() {
            Runtime rt = Runtime.getRuntime();
            long maxMemory = rt.maxMemory() / (1024 * 1024);
            long totalMemory = rt.totalMemory() / (1024 * 1024);
            long freeMemory = rt.freeMemory() / (1024 * 1024);
            long usedMemory = totalMemory - freeMemory;
            
            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>JVM Memory Management</title>
                    <style>
                        body { 
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
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
                        .nav { 
                            margin: 20px 0; 
                            text-align: center;
                        }
                        .nav a { 
                            display: inline-block; 
                            padding: 12px 25px; 
                            background: #3498db; 
                            color: white; 
                            text-decoration: none; 
                            margin: 5px; 
                            border-radius: 25px;
                            transition: all 0.3s ease;
                            font-weight: bold;
                        }
                        .nav a:hover {
                            background: #2980b9;
                            transform: translateY(-2px);
                        }
                        .current-page {
                            background: #e74c3c !important;
                        }
                        .memory-stats {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
                            gap: 15px;
                            margin: 20px 0;
                        }
                        .stat-card {
                            background: linear-gradient(135deg, #667eea, #764ba2);
                            color: white;
                            padding: 20px;
                            border-radius: 10px;
                            text-align: center;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>💾 JVM Memory Management</h1>
                        
                        <div class="nav">
                            <a href="/">🏠 Home</a>
                            <a href="/architecture">🏗️ Architecture</a>
                            <a href="/execution">⚡ Execution Flow</a>
                            <a href="/memory" class="current-page">💾 Memory</a>
                        </div>
                        
                        <div class="memory-stats">
                            <div class="stat-card">
                                <div>Max Memory</div>
                                <div style="font-size: 1.5em; font-weight: bold;">%d MB</div>
                            </div>
                            <div class="stat-card">
                                <div>Used Memory</div>
                                <div style="font-size: 1.5em; font-weight: bold;">%d MB</div>
                            </div>
                            <div class="stat-card">
                                <div>Free Memory</div>
                                <div style="font-size: 1.5em; font-weight: bold;">%d MB</div>
                            </div>
                            <div class="stat-card">
                                <div>Total Memory</div>
                                <div style="font-size: 1.5em; font-weight: bold;">%d MB</div>
                            </div>
                        </div>
                    </div>
                </body>
                </html>
                """.formatted(maxMemory, usedMemory, freeMemory, totalMemory);
        }
        
        private String createMainPage() {
            return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>JVM Web Server</title>
                    <style>
                        body { 
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
                            margin: 0; 
                            padding: 20px; 
                            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                            min-height: 100vh;
                        }
                        .container { 
                            max-width: 1000px; 
                            margin: 0 auto; 
                            background: white; 
                            padding: 40px; 
                            border-radius: 15px;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                            text-align: center;
                        }
                        .nav { 
                            margin: 30px 0; 
                        }
                        .nav a { 
                            display: inline-block; 
                            padding: 15px 30px; 
                            background: #3498db; 
                            color: white; 
                            text-decoration: none; 
                            margin: 10px; 
                            border-radius: 25px;
                            transition: all 0.3s ease;
                            font-weight: bold;
                            font-size: 1.1em;
                        }
                        .nav a:hover {
                            background: #2980b9;
                            transform: translateY(-3px);
                            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
                        }
                        h1 { color: #2c3e50; margin-bottom: 20px; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>☕ Java Virtual Machine (JVM) Web Server</h1>
                        <p style="font-size: 1.2em; color: #7f8c8d;">Explore the inner workings of the Java Virtual Machine</p>
                        
                        <div class="nav">
                            <a href="/architecture">🏗️ JVM Architecture</a>
                            <a href="/execution">⚡ Execution Flow</a>
                            <a href="/memory">💾 Memory Management</a>
                        </div>
                        
                        <div style="text-align: left; margin-top: 40px;">
                            <h3>📚 Learning Path:</h3>
                            <ol style="line-height: 1.8;">
                                <li><strong>Architecture</strong> - Understand the static components and structure</li>
                                <li><strong>Execution Flow</strong> - Learn the dynamic process of code execution</li>
                                <li><strong>Memory Management</strong> - Explore memory allocation and garbage collection</li>
                            </ol>
                        </div>
                    </div>
                </body>
                </html>
                """;
        }
    }
}