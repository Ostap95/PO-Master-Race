


class concreteVisitorA implements Visitor {

  // concrete visitor for get contents in paragraph and section
  // make concrete visitor for list sections ?? -> different ways to present lists
  // make concrete visitor for getHeadLine's ?? - document and section

  /**
  * Return content of the section
  * @return returns content of the section
  */
  public String visit(Section sec) {
    StringBuilder result = new StringBuilder();
    result.append(getHeadLine());

    if (_paragraphs != null) {
      for (Paragraph par : _paragraphs) {
        result.append(par.getContent());
      }
    }

    if (_subsections != null) {
      for (Section sec : _subsections) {
        result.append(sec.getContent());
      }
    }
      return result.toString();

  }

  /*
	* Return content of the paragraph
	* @return return string content of the paragraph
	*/
  @override
  public Strig visit(Paragraph p) {
    return _text+ "\n";
  }
}
