function WdatePicker() {
  if (document.activeElement && document.activeElement.tagName === "INPUT" && !document.activeElement.value) {
    document.activeElement.value = new Date().toISOString().slice(0, 10);
  }
}
