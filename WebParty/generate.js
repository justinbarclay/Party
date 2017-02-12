let mkdirp = require('mkdirp');
let path = require('path');
let fs = require('fs');
//
const structureName = process.argv[2];
const currentDirectory = __dirname;

generateReactRoute(structureName);

//This script assume that the root directory has a package.json file at the root directory
//and that no package.json exists in between the scripts directory and the root directory 
function getProjectRoot(directory, filename){ 
    found = false;        
    while(directory !== "/" && !found){
        file = path.resolve(directory, filename);
        console.log(file)
        if(fs.existsSync(file)){
            found = true;
        } else {
            directory = path.resolve(directory, "..");
        }
    }
    return {found: found, root: found ? file : ""}
}

function getProjectName(rootPath){
    let packageJson = require(packageLocation.root);
    return {found: packageLocation.found, root: packageLocation.path, project: packageJson.name || ""}
}

function generateReactRoute(routeName){
    project = getProjectRoot(__dirname, "")
    if(project.found){
        routePath = path.resolve(project.root, "src", "routes", routeName);
        mkdirp(path.resolve(routePath, "components"), function(err, folder){
            if(!err){
                console.log(routeName);
                fs.writeFile(path.resolve(folder, routeName + ".js" ), function(err){
                    console.error(err);
                });
            }
        });
        mkdirp(path.resolve(routePath, "modules"), function(err, folder){
            if(err){
                console.error(err);
            } else {
                fs.writeFile(path.resolve(folder, routeName + ".js" ), function(err){
                    if(err){
                        console.error(err);
                    }
                });
            }    
        });
        mkdirp(path.resolve(routePath, "containers"));
        fs.writeFile(path.resolve(routePath, "index.js" ), function(err){
            console.error(err);
        });
    }
}
