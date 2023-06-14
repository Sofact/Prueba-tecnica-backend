package com.neoris.pichincha.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.neoris.pichincha.model.ReporteDTO;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PDFExporter {

    public static byte[] exportToPDF(List<ReporteDTO> reporte) throws DocumentException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);

            document.open();

            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font fontNormal = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Paragraph titulo = new Paragraph("Reporte", fontTitulo);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingAfter(10f);
            document.add(titulo);

            for (ReporteDTO item : reporte) {
                Paragraph nombre = new Paragraph("Nombre: " + item.getPerNombre(), fontNormal);
                document.add(nombre);

                Paragraph cuentaId = new Paragraph("Cuenta ID: " + item.getCtaId(), fontNormal);
                document.add(cuentaId);

                Paragraph estado = new Paragraph("Estado: " + item.getCtaEstado(), fontNormal);
                document.add(estado);

                Paragraph numeroCuenta = new Paragraph("Número de cuenta: " + item.getCtaNumero(), fontNormal);
                document.add(numeroCuenta);

                Paragraph saldoInicial = new Paragraph("Saldo inicial: " + item.getCtaSaldoInicial(), fontNormal);
                document.add(saldoInicial);

                Paragraph tipoCuenta = new Paragraph("Tipo de cuenta: " + item.getCtaTipoCuenta(), fontNormal);
                document.add(tipoCuenta);

                Paragraph totalCreditos = new Paragraph("Total créditos: " + item.getTotalCreditos(), fontNormal);
                document.add(totalCreditos);

                Paragraph totalDebitos = new Paragraph("Total débitos: " + item.getTotalDebitos(), fontNormal);
                document.add(totalDebitos);

                Paragraph movSaldo = new Paragraph("Saldo: " + item.getMovSaldo(), fontNormal);
                document.add(movSaldo);

                Paragraph espacio = new Paragraph("\n", fontNormal);
                document.add(espacio);
            }

            document.close();

            return outputStream.toByteArray();
        } catch (Exception e) {
            System.err.println("Error al generar el archivo PDF: " + e.getMessage());
            return null;
        }
    }

    public static Date convertStringToDate(String dateString, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(dateString);
    }
}
