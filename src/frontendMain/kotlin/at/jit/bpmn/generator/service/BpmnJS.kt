package at.jit.bpmn.generator.service


@JsModule("bpmn-js/lib/NavigatedViewer")
@JsNonModule
external val BpmnNavigatedViewer: dynamic

@JsModule("bpmn-js/lib/Modeler")
@JsNonModule
external val BpmnJSModelerModule: dynamic


const val bpmnXML = """<?xml version="1.0" encoding="UTF-8"?>
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" id="Definitions_0abmhy8" targetNamespace="http://bpmn.io/schema/bpmn" exporter="Camunda Modeler" exporterVersion="3.0.0-dev">
  <bpmn:process id="Process_1ua2vit" isExecutable="true">
    <bpmn:startEvent id="StartEvent_1" />
  </bpmn:process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_1">
    <bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Process_1ua2vit">
      <bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">
        <dc:Bounds x="179" y="159" width="36" height="36" />
      </bpmndi:BPMNShape>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</bpmn:definitions>
"""

const val bpmnXml2 = """<?xml version="1.0" encoding="UTF-8"?>
<bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:dc="http://www.omg.org/spec/DD/20100524/DC" xmlns:di="http://www.omg.org/spec/DD/20100524/DI" id="Definitions_1l24c1e" targetNamespace="http://bpmn.io/schema/bpmn" exporter="Camunda Modeler" exporterVersion="4.6.0">
  <bpmn:process id="Process_1eplgyw" isExecutable="true">
    <bpmn:startEvent id="StartEvent_1" name="start">
      <bpmn:outgoing>Flow_08gkhcc</bpmn:outgoing>
    </bpmn:startEvent>
    <bpmn:sequenceFlow id="Flow_08gkhcc" sourceRef="StartEvent_1" targetRef="Activity_09im477" />
    <bpmn:endEvent id="Event_0mbk9eu" name="end">
      <bpmn:incoming>Flow_1ggxiu5</bpmn:incoming>
    </bpmn:endEvent>
    <bpmn:sequenceFlow id="Flow_1axare0" sourceRef="Activity_09im477" targetRef="Activity_0wmho5v" />
    <bpmn:serviceTask id="Activity_09im477" name="test task">
      <bpmn:incoming>Flow_08gkhcc</bpmn:incoming>
      <bpmn:outgoing>Flow_1axare0</bpmn:outgoing>
    </bpmn:serviceTask>
    <bpmn:task id="Activity_0wmho5v" name="other task">
      <bpmn:incoming>Flow_1axare0</bpmn:incoming>
      <bpmn:outgoing>Flow_1ggxiu5</bpmn:outgoing>
    </bpmn:task>
    <bpmn:sequenceFlow id="Flow_1ggxiu5" sourceRef="Activity_0wmho5v" targetRef="Event_0mbk9eu" />
  </bpmn:process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_1">
    <bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="Process_1eplgyw">
      <bpmndi:BPMNEdge id="Flow_08gkhcc_di" bpmnElement="Flow_08gkhcc">
        <di:waypoint x="215" y="117" />
        <di:waypoint x="270" y="117" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1axare0_di" bpmnElement="Flow_1axare0">
        <di:waypoint x="370" y="117" />
        <di:waypoint x="470" y="117" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge id="Flow_1ggxiu5_di" bpmnElement="Flow_1ggxiu5">
        <di:waypoint x="570" y="117" />
        <di:waypoint x="682" y="117" />
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="StartEvent_1">
        <dc:Bounds x="179" y="99" width="36" height="36" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="186" y="142" width="23" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0i97fjt_di" bpmnElement="Activity_09im477">
        <dc:Bounds x="270" y="77" width="100" height="80" />
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Event_0mbk9eu_di" bpmnElement="Event_0mbk9eu">
        <dc:Bounds x="682" y="99" width="36" height="36" />
        <bpmndi:BPMNLabel>
          <dc:Bounds x="691" y="142" width="19" height="14" />
        </bpmndi:BPMNLabel>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape id="Activity_0wmho5v_di" bpmnElement="Activity_0wmho5v">
        <dc:Bounds x="470" y="77" width="100" height="80" />
      </bpmndi:BPMNShape>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</bpmn:definitions>
"""