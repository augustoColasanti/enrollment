$desc = $args[0]

if ($desc -eq "install") {
    Write-Host "Installing enrollment"
    ./mvnw install
} elseif ($desc -eq "run") {
    Write-Host "Running enrollment..."
    docker-compose up -d
    java -jar target/enrollment-0.0.1-SNAPSHOT.jar
} elseif ($desc -eq "test") {
    Write-Host "Testing enrollment..."
    ./mvnw test
} elseif ($desc -eq "deploy") {
    Write-Host "Deploying enrollment..."
    ./mvnw clean install
}
