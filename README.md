# Orchestra Module Template

A basic template for creating modules for the **Orchestra System**.

This project provides the minimum structure required to create an Orchestra module and can be used as a starting point for developing custom modules, services, jobs, and FaaS functionality.

---

## Overview

An Orchestra module is a dynamically loaded component of the Orchestra System.

A module can contain:

- Module lifecycle logic
- Services
- Entities
- Database access
- Scheduled jobs
- Configuration
- Groovy/Kotlin scripts
- FaaS functions
- External integrations

This repository provides a simple starting point without unnecessary application code.

---

## Project Structure

```text
module/
└── src/
    └── main/
        ├── groovy/
        │   └── ...
        │
        └── orchestra/
            ├── Environment.groovy
            └── Module.groovy    
```

## Module Lifecycle  
An Orchestra module can implement the IModule interface.
```groovy
class Module implements IModule {

    @Override
    void start() {
        println "Module started"
    }

    @Override
    void stop() {
        println "Module stopped"
    }
}
```   

The lifecycle consists of two main operations:   
```text
start()
   │
   ▼
Module is running
   │
   ▼
stop()
```  

`start()`   
Called when Orchestra starts the module.
Use this method for initialization tasks such as:   
* Registering services
* Initializing resources
* Starting background processes
* Loading module configuration

`stop()`   

Called when Orchestra stops the module.   
Use this method for cleanup tasks such as:

* Closing resources
* Stopping background processes
* Unregistering services   
