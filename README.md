# MTD Manager Framework
This directory collects works about Moving Target Defense (MTD) connected to the DEFEDGE organization hosted by `University of Naples Federico II`.

The `Setups` folder collects all the readmes that you need to understand the purpose of this repository:
1. The [Framework description](Setups/Framework_description.md) file describes the first work done in the context of [DEFEDGE - PRIN PNRR 2022 Project]([https://github.com/DEFEDGE](https://defedge.dieti.unina.it/)) where a framework was built to perform MTD techniques on a kubernetes cluster [1].
2. The [Framework setup](Setups/Framework_setup.md) file describes the steps needed to deploy the framework given the cluster that can be installed following this [kubernetes guide](Setups/How_to_kubernetes.md) and this [ubuntu guide](Setups/Ubuntu_Server.md).
3. The `src` folder contains the JAVA code for the framework that can be executed with the `build_and_run.sh` script.
4. In the context of the cluster, you'll install Prometheus for monitoring purposes and you can add [Grafana](Setups/Grafana_setup.md) to interact with a web UI giving access to custom dashboards representing the cluster status.
5. As a test case, a simple [application](Setups/Bank_setup.md) was implemented and deployed on the system (for further details refer to the [requirement file](Setups/Bank_req_sec.md) for more insights about the application and its security requirements and the [dedicated grafana dshboard](Setups/Bank_Grafana_Setup.md) file for monitoring the cluster and application status).
6. In the [falco description file](Setups/Falco_description.md) you can find insights about this cloud-based technology with reference to the official documentation, while in the [falco setup file](Setups/Falco_setup.md) you can find a step by step guide to its deployment on the cluster [2].


---
## Reference
[1] Casola, V., De Benedictis, A., Iorio, D., Migliaccio, S.: A moving target defense framework to improve resilience of cloud-edge systems. In: Barolli, L. (ed.) Advanced Information Networking and Applications. pp. 243–252. Springer Nature Switzerland, Cham (2025). [DOI](https://doi.org/10.1007/978-3-031-87778-0_24) 

[2] Iorio, D., De Benedictis, A. (2027). AMTD-EC: An Adaptive Moving Target Defense Framework for Edge-Cloud Systems. In: Kieseberg, P., Skopik, F., Atli, B., Asplund, M. (eds) Availability, Reliability and Security. ARES 2026 EU Projects Symposium Workshops. ARES 2026. Lecture Notes in Computer Science, vol 16903. Springer, Cham. [DOI](https://doi.org/10.1007/978-3-032-37218-5_36) 


[3] Casola, V., De Benedictis, A. & Iorio, D. Moving target defense in Edge-Cloud systems: a systematic literature review. J Cloud Comp 15, 113 (2026). [DOI](https://doi.org/10.1186/s13677-026-00920-7) 

---
Corresponding author: 

Daniele Iorio, PhD student in Technology, Innovation and Management (TIM) @ University of Bergamo in conv. with University of Naples "Federico II"

Contacts: daniele.iorio2@unina.it ; daniele.iorio@unibg.it
