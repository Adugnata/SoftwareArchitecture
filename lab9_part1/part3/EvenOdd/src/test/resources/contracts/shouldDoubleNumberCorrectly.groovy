package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "double a number"
    request{
        method GET()
        url("/double") {
            queryParameters {
                parameter("number", "4")
            }
        }
    }
    response {
        body("8")
        status 200
    }
}