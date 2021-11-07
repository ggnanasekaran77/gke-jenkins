multibranchPipelineJob('example') {
    branchSources {
        branchSource {
            source {
                git {
                    id('configserver')
                    remote('https://github.com/ggnanasekaran77/configserver.git')
                }
            }
            strategy {
                allBranchesSame {
                    props {
                        suppressAutomaticTriggering()
                    }
                }
            }
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}



multibranchPipelineJob('configserver') {
    branchSources {
        branchSource {
            source {
                git {
                    id('configserver')
                    remote('https://github.com/ggnanasekaran77/configserver.git')
                    traits {
                        gitBranchDiscovery()
                    }
                }
            }
            buildStrategies {
                buildAllBranches {
                    strategies {
                        skipInitialBuildOnFirstBranchIndexing()
                    }
                }
            }
        }
    }
    triggers {
        computedFolderWebHookTrigger {
            token('configserver')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
