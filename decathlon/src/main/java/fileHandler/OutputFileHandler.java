package fileHandler;

import disciplines.Discipline;
import disciplines.DisciplineHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import participant.Participant;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class OutputFileHandler {

    public void writeScoreTableToXML(List<Participant> participantList, String path) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = createElement(document, "Scoreboard");
            addParticipantToScoreBoard(participantList, root, document);
            createXMLFile(document, path);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createXMLFile(Document document, String path) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(path));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void addParticipantToScoreBoard(List<Participant> participantList, Element root, Document document) {
        int placeCounter = 1;
        for (int i = 0; i < participantList.size(); i++) {
            String place = assignPlace(placeCounter, participantList, i);
            String participantName = participantList.get(i).getName();

            Element participantElement = createElement(root, document, "Participant");
            createElement(participantElement, document, place, "Place");
            createElement(participantElement, document, participantName, "Name");
            addResultsWithTotalScore(participantList.get(i), document, participantElement);
            placeCounter++;
        }
    }

    private String assignPlace(int placeCounter, List<Participant> participantList, int index) {
        String place;
        if (compareNextParticipant(participantList, index)) {
            place = String.format("%d-%d", placeCounter, placeCounter + 1);
        } else if (comparePrevParticipant(participantList, index)) {
            place = String.format("%d-%d", placeCounter - 1, placeCounter);
        } else {
            place = String.format("%d", placeCounter);
        }
        return place;
    }

    private boolean compareNextParticipant(List<Participant> participantList, int index) {
        if (index + 1 < participantList.size()) {
            String participantTotalScore = participantList.get(index).getTotalScore();
            String nextParticipantTotalScore = participantList.get(index + 1).getTotalScore();
            if (participantTotalScore != null && nextParticipantTotalScore != null) {
                return participantTotalScore.equals(nextParticipantTotalScore);
            }
        }
        return false;
    }

    private boolean comparePrevParticipant(List<Participant> participantList, int index) {
        if (index > 0) {
            String participantTotalScore = participantList.get(index).getTotalScore();
            String prevParticipantTotalScore = participantList.get(index - 1).getTotalScore();
            if (participantTotalScore != null && prevParticipantTotalScore != null) {
                return participantTotalScore.equals(prevParticipantTotalScore);
            }
        }
        return false;
    }

    private void addResultsWithTotalScore(Participant participant, Document document, Element participantElement) {
        List<String> valueList = participant.getResults();
        List<Discipline> disciplineList = DisciplineHandler.getDisciplinesList();
        String totalScore = participant.getTotalScore();
        Element disciplineElement = createElement(participantElement, document, "Disciplines");

        for (int i = 0; i < valueList.size(); i++) {
            Discipline discipline = disciplineList.get(i);
            String value = valueList.get(i);
            createElement(disciplineElement, document, value, discipline.toString());
        }
        createElement(participantElement, document, totalScore, "TotalScore");
    }

    private Element createElement(Document document, String elementName) {
        Element element = document.createElement(elementName);
        document.appendChild(element);
        return element;
    }

    private Element createElement(Element parentElement, Document document, String elementName) {
        Element element = document.createElement(elementName);
        parentElement.appendChild(element);
        return element;
    }

    private void createElement(Element element, Document document, String value, String elementName) {
        Element newElement = document.createElement(elementName);
        addValueToElement(newElement, document, value);
        element.appendChild(newElement);
    }

    private void addValueToElement(Element element, Document document, String value) {
        if (value != null) {
            element.appendChild(document.createTextNode(value));
        }
    }
}
