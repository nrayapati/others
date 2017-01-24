node {
    withEnv(['JIRA_SITE=LOCAL']) {
     stage('JIRA Query Component') {
        response = jiraGetComponentIssueCount id: 10000 
        // echo response.successful.toString()
        // echo response.data.toString()
        // echo response.error.toString()
        response = jiraGetComponent id: 10000
        // echo response.successful.toString()
        def comp =  response.data
        // echo comp.toString()
        // echo response.error.toString()
        response = jiraUpdateComponent component: comp, failOnError:false
        // echo response.successful.toString()
        // echo response.data.toString()
        // echo response.error.toString()
     }
     stage('JIRA New Componet') {
        withEnv(['JIRA_SITE=NARESH']) {
            def component = [name: "testing001", project: "TEST"]
            // echo component.toString()
            response = jiraNewComponent component: component, failOnError:false
            // echo response.successful.toString()
        }
            def component = [name: "testing001", project: "TEST"]
            // echo component.toString()
            response = jiraNewComponent component: component, failOnError:false
            // echo response.successful.toString()
        //  if(!response.success) {
        //      error response.error
        //  }
     }
    //  stage('JIRA New Issue') {
    //     def issue = [fields: [project: [id: "10000"],
    //                           summary: "New JIRA from Jenkins, heyyyyy.",
    //                           issuetype: [id: "3"]]]
    //     echo issue.toString()                      
    //     response = jiraNewIssue issue: issue
    //     echo response.successful.toString()
    //     echo response.data.toString()
    //  }
    }
    // withEnv(['HUBOT_SERVICE_URL=http://10.184.179.155:9999']) {
    //     stage('Build') {
    //         hubotApprove message: 'Approve staging deployment?'
    //         input id: 'Proceed', message: 'Approve staging deployment?'
    //     }
    // }
}
