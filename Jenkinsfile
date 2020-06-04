pipeline {
    agent any
    tools {
        maven 'm3'
    }
    stages{
        stage ('Checkout'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Checkout===`-._,-'`-._,-'`-._,-'`-._,-'"
                git credentialsId: 'GitLabNomadsMassage', url: 'https://gitlab.com/nomadsgroupe/nomadsrest.git'
                // sh 'ls -laR'
            }
        }
        stage ('Cleaning'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Cleaning===`-._,-'`-._,-'`-._,-'`-._,-'"
                sh "mvn -f nomadsProjectStocksItf/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseurItf/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f wsRestCurrenciesItf/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfItf/pom.xml clean  | sed 's/^/      /'"
                
                sh "mvn -f nomadsProjectStocks/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseur/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f wsRestCurrencies/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWsRest/pom.xml clean  | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWeb/pom.xml clean  | sed 's/^/      /'"
                
            }
        }
        stage ('install ITF'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===install ITF===`-._,-'`-._,-'`-._,-'`-._,-'"
                sh "mvn -f nomadsProjectStocksItf/pom.xml install -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseurItf/pom.xml install -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrenciesItf/pom.xml install -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfItf/pom.xml install -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                

            }
            
        }
        stage ('Compile'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Compile===`-._,-'`-._,-'`-._,-'`-._,-'"
                
                sh "mvn -f nomadsProjectStocks/pom.xml compile -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseur/pom.xml compile -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrencies/pom.xml compile -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWsRest/pom.xml compile -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWeb/pom.xml compile -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
            }
            
        }
        stage ('Test'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Test===`-._,-'`-._,-'`-._,-'`-._,-'"
                sh "mvn -f nomadsProjectStocksItf/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseurItf/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrenciesItf/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfItf/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                
                sh "mvn -f nomadsProjectStocks/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData  | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseur/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData  | sed 's/^/      /'"
                sh "mvn -f wsRestCurrencies/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData  | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWsRest/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData  | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWeb/pom.xml test -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
            }
		
            
        }
        stage ('Code coverage'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Couverture===`-._,-'`-._,-'`-._,-'`-._,-'"
                jacoco (
                    execPattern: '**/target/*.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src/main/java',
                    exclusionPattern: '**/src/test*'
                )
            }
            
        }
        stage ('Sanity Check'){
            steps {
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Sanity Check===`-._,-'`-._,-'`-._,-'`-._,-'"
                sh "mvn -f nomadsProjectStocksItf/pom.xml  checkstyle:checkstyle pmd:pmd  -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseurItf/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrenciesItf/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfItf/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                
                sh "mvn -f nomadsProjectStocks/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseur/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrencies/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWsRest/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWeb/pom.xml  checkstyle:checkstyle pmd:pmd -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
 
            }
			
            post {
                always {
					recordIssues enabledForFailure: true, tools: [checkStyle()]

					  script {					
					/*
                    def nomadsProjectStocksItf = scanForIssues tool: [$class: 'Pmd'], pattern: 'nomadsProjectStocksItf/target/pmd.xml'
					publishIssues issues:[nomadsProjectStocksItf]
						def AnnuaireMasseurItf = scanForIssues tool: [$class: 'Pmd'], pattern: 'AnnuaireMasseurItf/target/pmd.xml'
					publishIssues issues:[AnnuaireMasseurItf]
					
					def wsRestCurrenciesItf = scanForIssues tool: [$class: 'Pmd'], pattern: 'wsRestCurrenciesItf/target/pmd.xml'
					publishIssues issues:[wsRestCurrenciesItf]
					
					def nomadsProjectSpringBootJsfItf = scanForIssues tool: [$class: 'Pmd'], pattern: 'nomadsProjectSpringBootJsfItf/target/pmd.xml'
					publishIssues issues:[nomadsProjectSpringBootJsfItf]
					
					def nomadsProjectStocks = scanForIssues tool: [$class: 'Pmd'], pattern: 'nomadsProjectStocks/target/pmd.xml'
					publishIssues issues:[nomadsProjectStocks]
				
					def AnnuaireMasseur = scanForIssues tool: [$class: 'Pmd'], pattern: 'AnnuaireMasseur/target/pmd.xml'
					publishIssues issues:[AnnuaireMasseur]
					*/
					def wsRestCurrencies = scanForIssues tool: [$class: 'Pmd'], pattern: 'wsRestCurrencies/target/pmd.xml'
					publishIssues issues:[wsRestCurrencies]
					/*
				    def nomadsProjectSpringBootJsfWsRest = scanForIssues tool: [$class: 'Pmd'], pattern: 'nomadsProjectSpringBootJsfWsRest/target/pmd.xml'
					publishIssues issues:[nomadsProjectSpringBootJsfWsRest]
				
					
					def nomadsProjectSpringBootJsfWeb = scanForIssues tool: [$class: 'Pmd'], pattern: 'nomadsProjectSpringBootJsfWeb/target/pmd.xml'
					publishIssues issues:[nomadsProjectSpringBootJsfWeb]
					*/
                    }
					
			    }
            }
        }
        
	    stage ('Packaging'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Packaging===`-._,-'`-._,-'`-._,-'`-._,-'"
        
                sh "mvn -f nomadsProjectStocks/pom.xml package -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f AnnuaireMasseur/pom.xml package -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f wsRestCurrencies/pom.xml package -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWsRest/pom.xml package -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
                sh "mvn -f nomadsProjectSpringBootJsfWeb/pom.xml package -Dmaven.test.skip=true -Dspring-boot.run.profiles=configEclipse,initData | sed 's/^/      /'"
            }
        }
        stage ('Cleaning Dockers'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Cleaning Dockers only because build successS===`-._,-'`-._,-'`-._,-'`-._,-'"
                script {
                    try {
                        sh 'docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q)'
                    }catch (Exception e) {
                        echo 'no contenaire to remove!!!'
                    }
                    try {
                        sh 'docker rmi -f $(docker images -q)'
                    }catch (Exception e) {
                        echo 'no contenaire to remove!!!'
                    }
                    try {
                        sh 'docker volume rm $(docker volume ls -q)'
                    }catch (Exception e) {
                        echo 'no volume to remove!!!'
                    }
                    try {
                        sh 'docker network prune -f'
                    }catch (Exception e) {
                        echo 'no network to remove!!!'
                    }
                }                
            }
        }
        stage ('docker build'){
            steps{
                echo "`-._,-'`-._,-'`-._,-'`-._,-'===Docker build image stage===`-._,-'`-._,-'`-._,-'`-._,-'"
				sh "docker-compose -f ./AnnuaireMasseur/docker-compose.yml -p annuaire up -d"
				sh "docker-compose -f ./nomadsProjectStocks/docker-compose.yml -p stocks up -d"
                sh "docker-compose -f ./nomadsProjectSpringBootJsfWsRest/docker-compose.yml -p rest up -d"
                sh "docker-compose -f ./wsRestCurrencies/docker-compose.yml -p currency up -d"
                sh "docker-compose -f ./nomadsProjectSpringBootJsfWeb/docker-compose.yml -p web up -d"
              
            }
        }
        
    }
    
}

