const val bpmnXML = """<?xml version="1.0" encoding="UTF-8"?>
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" id="Definitions_1l24c1e" targetNamespace="http://bpmn.io/schema/bpmn" exporter="Camunda Modeler" exporterVersion="4.6.0">
<bpmn:process id="Process_1eplgyw" isExecutable="true">
<bpmn:startEvent id="StartEvent_1" name="start">
<bpmn:outgoing>Flow_08gkhcc</bpmn:outgoing>
</bpmn:startEvent>
<bpmn:sequenceFlow id="Flow_08gkhcc" sourceRef="StartEvent_1" targetRef="Activity_09im477" />
<bpmn:endEvent id="Event_0mbk9eu" name="end">
<bpmn:incoming>Flow_1axare0</bpmn:incoming>
</bpmn:endEvent>
<bpmn:sequenceFlow id="Flow_1axare0" sourceRef="Activity_09im477" targetRef="Event_0mbk9eu" />
<bpmn:serviceTask id="Activity_09im477" name="test task">
<bpmn:incoming>Flow_08gkhcc</bpmn:incoming>
<bpmn:outgoing>Flow_1axare0</bpmn:outgoing>
</bpmn:serviceTask>
</bpmn:process>
<bpmndi:BPMNDiagram id="BPMNDiagram_1">
<bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Process_1eplgyw">
<bpmndi:BPMNEdge id="Flow_08gkhcc_di" bpmnElement="Flow_08gkhcc">
<di:waypoint x="215" y="117" />
<di:waypoint x="270" y="117" />
</bpmndi:BPMNEdge>
<bpmndi:BPMNEdge id="Flow_1axare0_di" bpmnElement="Flow_1axare0">
<di:waypoint x="370" y="117" />
<di:waypoint x="432" y="117" />
</bpmndi:BPMNEdge>
<bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">
<dc:Bounds x="179" y="99" width="36" height="36" />
<bpmndi:BPMNLabel>
  <dc:Bounds x="186" y="142" width="23" height="14" />
</bpmndi:BPMNLabel>
</bpmndi:BPMNShape>
<bpmndi:BPMNShape id="Event_0mbk9eu_di" bpmnElement="Event_0mbk9eu">
<dc:Bounds x="432" y="99" width="36" height="36" />
<bpmndi:BPMNLabel>
  <dc:Bounds x="441" y="142" width="19" height="14" />
</bpmndi:BPMNLabel>
</bpmndi:BPMNShape>
<bpmndi:BPMNShape id="Activity_0i97fjt_di" bpmnElement="Activity_09im477">
<dc:Bounds x="270" y="77" width="100" height="80" />
</bpmndi:BPMNShape>
</bpmndi:BPMNPlane>
</bpmndi:BPMNDiagram>
</bpmn:definitions>
"""